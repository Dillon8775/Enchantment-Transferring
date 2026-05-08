package net.dillon.enchantmenttransferring.menu;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.dillon.enchantmenttransferring.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.level.block.state.BlockState;

import java.util.HashMap;
import java.util.Map;

/**
 * Screen and enchantment transferring handling for the {@code Enchantment Transferrer block.}
 */
public class EnchantmentTransferrerMenu extends ItemCombinerMenu {
    private final DataSlot levelCost = DataSlot.standalone(); // Level cost variable
    private final Map<Holder, Integer> enchantmentsToRemove = new HashMap<>(); // List of enchantments to remove from the item, with their respective level
    private final Map<Object2IntMap.Entry<Holder<Enchantment>>, Integer> enchantmentsToTransfer = new HashMap<>(); // List of enchantments to transfer over, with their respective level (mapped)

    /**
     * Constructor for registering this screen handler.
     */
    public EnchantmentTransferrerMenu(int syncId, Inventory inventory) {
        this(syncId, inventory, ContainerLevelAccess.NULL);
    }

    /**
     * Base constructor.
     */
    public EnchantmentTransferrerMenu(int syncId, Inventory inventory, ContainerLevelAccess context) {
        super(ModMenus.ENCHANTMENT_TRANSFERRER, syncId, inventory, context, getForgingSlotsManager());
        this.addDataSlot(this.levelCost);
    }

    /**
     * Copied over from {@link AnvilMenu}. Sets the slot's position on the screen.
     */
    private static ItemCombinerMenuSlotDefinition getForgingSlotsManager() {
        return ItemCombinerMenuSlotDefinition.create()
                .withSlot(0, 27, 47, stack -> true) // Enchanted tool
                .withSlot(1, 76, 47, stack -> true) // Tool to transfer to
                .withResultSlot(2, 134, 47).build(); // Output
    }

    /**
     * This screen can only be opened with a {@code Enchantment Transferrer.}
     */
    @Override
    protected boolean isValidBlock(BlockState state) {
        return state.is(ModBlocks.ENCHANTMENT_TRANSFERRER);
    }

    /**
     * Determines if the player can take the outputted item.
     * <p>In this case, if the player is in creative mode or if they have enough levels.</p>
     */
    @Override
    protected boolean mayPickup(Player player, boolean present) {
        return (player.hasInfiniteMaterials() || player.experienceLevel >= this.levelCost.get()) && this.levelCost.get() > 0;
    }

    /**
     * Refresh the slots and give the player the item.
     */
    @Override
    public void onTake(Player player, ItemStack stack) {
        if (!player.getAbilities().instabuild) {
            player.giveExperienceLevels(-this.levelCost.get());
        }

        ItemStack newSlot1 = this.inputSlots.getItem(0);
        // Remove the enchantment from the main hand item if it was transferred/upgraded to the offhand
        for (Holder registryEntry : enchantmentsToRemove.keySet()) {
            EnchantmentHelper.updateEnchantments(newSlot1, builder -> builder.removeIf(enchantmentRegistryEntry -> enchantmentRegistryEntry.equals(registryEntry)));
        }
        this.inputSlots.setItem(0, newSlot1);
        this.inputSlots.setItem(1, ItemStack.EMPTY);
        this.success(player);
    }

    /**
     * Handles transferring enchantments.
     * <p>See additional comments inside of this method for more documentation.</p>
     */
    @Override
    public void createResult() {
        ItemStack firstSlot = this.inputSlots.getItem(0); // Get the stack in the first slot
        ItemStack secondSlot = this.inputSlots.getItem(1); // Get the stack in the second slot
        ItemEnchantments slot1Enchantments = EnchantmentHelper.getEnchantmentsForCrafting(firstSlot); // Enchantments on first slot stack
        ItemEnchantments slot2Enchantments = EnchantmentHelper.getEnchantmentsForCrafting(secondSlot); // Enchantments on second slot stack
        ItemEnchantments.Mutable firstSlotBuilder = new ItemEnchantments.Mutable(slot1Enchantments); // Build enchantments component on first slot
        ItemEnchantments.Mutable secondSlotBuilder = new ItemEnchantments.Mutable(slot2Enchantments); // Build enchantments component on second slot

        this.resultSlots.setItem(0, ItemStack.EMPTY); // Reset the output initially to nothing
        this.levelCost.set(0); // Reset the level cost
        this.enchantmentsToTransfer.clear(); // Reset enchantments to transfer
        this.enchantmentsToRemove.clear(); // Reset enchantments to remove

        // If slot 1 or 2 is empty, OR is of enchanted book, make sure nothing is returned
        if (firstSlot.isEmpty() || secondSlot.isEmpty() || firstSlot.is(Items.ENCHANTED_BOOK) || secondSlot.is(Items.ENCHANTED_BOOK)) {
            return;
        }

        // Run through all enchantments in the first slot
        for (Object2IntMap.Entry<Holder<Enchantment>> entry : slot1Enchantments.entrySet()) {
            Holder registryEntry = entry.getKey();
            Enchantment enchantment = (Enchantment)registryEntry.value();

            // If second slot has no enchantments, and the enchantment wanting to be transferred is acceptable, transfer the enchantment
            if (!secondSlot.isEnchanted() && enchantment.canEnchant(secondSlot)) {
                enchantmentsToTransfer.put(entry, firstSlotBuilder.getLevel(entry.getKey()));
                enchantmentsToRemove.put(entry.getKey(), firstSlotBuilder.getLevel(entry.getKey()));
                this.broadcastChanges();
            } else { // Otherwise, start running through all second slot enchantments to determine acceptability
                boolean allIsCompatible = true; // All enchantments are compatible
                for (Holder<Enchantment> registryEntry2 : secondSlotBuilder.keySet()) {

                    // Compare first second and second slot enchantments and determine if they are compatible with each other
                    for (Holder<Enchantment> existingEnchantment : secondSlotBuilder.keySet()) {
                        if (!Enchantment.areCompatible(existingEnchantment, registryEntry) && !registryEntry2.equals(registryEntry)) {
                            allIsCompatible = false; // If not, not all enchantments are compatible
                            break; // Break out of the loop, no further action needed here
                        }
                    }

                    // Determines if an enchantment in second slot can be upgraded to a higher level
                    boolean alreadyPresentButUpgradable = registryEntry2.equals(registryEntry) && secondSlotBuilder.getLevel(registryEntry2) < firstSlotBuilder.getLevel(registryEntry);

                    // If all enchantments are compatible with each other and can be combined, OR can be upgraded
                    // Try to transfer enchantments
                    if ((allIsCompatible && enchantment.canEnchant(secondSlot)) || alreadyPresentButUpgradable) {
                        if (secondSlotBuilder.getLevel(entry.getKey()) != enchantment.getMaxLevel() // ensure enchantment isn't already at max level; if it is then ignore transferring
                                && firstSlotBuilder.getLevel(entry.getKey()) != secondSlotBuilder.getLevel(entry.getKey()) // ensure first slot enchantment level isn't the same as second slot enchantment level
                                && secondSlotBuilder.getLevel(entry.getKey()) < firstSlotBuilder.getLevel(entry.getKey())) { // ensure first slot enchantment level isn't less than the second slot enchantment level
                            enchantmentsToTransfer.put(entry, firstSlotBuilder.getLevel(entry.getKey()));
                            enchantmentsToRemove.put(entry.getKey(), firstSlotBuilder.getLevel(entry.getKey()));
                            this.broadcastChanges();
                        }
                    }
                }
            }
        }

        // Applies the transferred enchantments to the output item.
        ItemStack output = secondSlot.copy(); // Copy second slot stack
        // Total transferred enchantments equals the number of enchantments to transfer (map cannot contain duplicates, so the size is correct)
        int totalTransferredEnchantments = enchantmentsToTransfer.size();
        // Run through all enchantments to transfer
        for (Object2IntMap.Entry<Holder<Enchantment>> entry : enchantmentsToTransfer.keySet()) {
            int firstSlotLevel = firstSlotBuilder.getLevel(entry.getKey());
            int secondSlotLevel = secondSlotBuilder.getLevel(entry.getKey());

            // Check if second slot already has the enchantment
            if (secondSlotLevel > 0) {
                // If second slot has a lower level, upgrade it
                if (secondSlotLevel < firstSlotLevel) {
                    EnchantmentHelper.updateEnchantments(output, builder -> builder.upgrade(entry.getKey(), firstSlotLevel));
                }
                // No further action needed if the levels are equal or second slot has a higher level
            } else {
                // If second slot does not have the enchantment, transfer it
                EnchantmentHelper.updateEnchantments(output, builder -> builder.upgrade(entry.getKey(), firstSlotLevel));
            }
        }
        int cost = 0; // Cost variable (initially set to 0).
        double outputDurability = output.getMaxDamage() - output.getDamageValue(); // New outputDurability amount
        if (totalTransferredEnchantments > 0) { // as long as at least one enchantment is transferred...
            cost += totalTransferredEnchantments; // set cost to total transferred enchantments
            // For each enchantment, get the enchantment level, and add it to cost
            // Additionally, divide output durability by (1.0 + (each enchantment level * 0.1))
            for (Map.Entry<Object2IntMap.Entry<Holder<Enchantment>>, Integer> entry : enchantmentsToTransfer.entrySet()) {
                cost += entry.getValue(); // cost = (totalTransferredEnchantments + (eachEnchantmentsLevel))
                outputDurability /= 1.0 + (entry.getValue() * 0.1); // outputDurability = (1.0 + (eachEnchantmentLevel * 0.1)) (ex. efficiency 5 would do -> outputDurability / 1.5, fortune 3 would do -> outputDurability / 1.3)
            }
            // Set damage to output durability
            int newOutputDamage = output.getMaxDamage() - (int)outputDurability;
            output.setDamageValue(Mth.clamp(newOutputDamage, 0, output.getMaxDamage()));
            this.resultSlots.setItem(0, output); // Set the output
            this.levelCost.set(cost); // Set the cost
        }
    }

    /**
     * A successful enchantment transfer.
     */
    private void success(Player player) {
        player.playSound(SoundEvents.SMITHING_TABLE_USE, 1.0F, this.player.getRandom().nextFloat() * 0.1F + 0.9F);
        player.giveExperienceLevels(this.levelCost.get());
    }

    /**
     * Returns the current level cost.
     */
    public int getLevelCost() {
        return this.levelCost.get();
    }
}