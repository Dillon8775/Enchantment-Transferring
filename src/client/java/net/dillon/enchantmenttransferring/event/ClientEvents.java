package net.dillon.enchantmenttransferring.event;

import net.dillon.dillonlib.task.CommonTasks;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;

import static net.dillon.enchantmenttransferring.helper.ModConstants.MOD_INFO;

/**
 * Client events for Enchantment Transferring.
 */
public class ClientEvents {

    public static void registerClientEvents() {
        ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> {
            CommonTasks.sendUpdateMessage(MOD_INFO, client.player);
        });
    }
}