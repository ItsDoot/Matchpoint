package com.expansemc.matchpoint.api.kit.handler;

import com.expansemc.matchpoint.api.kit.KitException;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;

/**
 * The equip handler is called whenever the player equips the kit.
 */
@FunctionalInterface
public interface EquipKitHandler {
    void onEquip(final ServerPlayer player) throws KitException;
}