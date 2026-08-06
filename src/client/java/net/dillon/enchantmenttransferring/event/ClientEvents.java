package net.dillon.enchantmenttransferring.event;

import net.dillon.dillonlib.task.CommonTasks;
import net.dillon.dillonlib.util.UpdateChecker;
import net.dillon.enchantmenttransferring.platform.EtPlatforms;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;

/**
 * Client events for Enchantment Transferring.
 */
public class ClientEvents {
    public static final boolean HAS_UPDATE = UpdateChecker.hasUpdate(UpdateChecker.checkForUpdate(
            "enchantment-transferring",
            EtPlatforms.getPlatform().modVersion()
    ));

    public static void registerClientEvents() {
        ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> {
            if (HAS_UPDATE) {
                CommonTasks.sendUpdateMessage(client.player,
                        Component.translatable("itemGroup.enchantmenttransferring.enchantment_transferring_item_group").withStyle(ChatFormatting.AQUA),
                        "https://modrinth.com/mod/enchantment-transferring/versions",
                        TextColor.GOLD.getValue());
            }
        });
    }
}