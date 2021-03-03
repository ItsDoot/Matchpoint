package com.expansemc.matchpoint.api.kit.handler;

import com.expansemc.matchpoint.api.kit.KitException;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;

/**
 * The unequip handler is called whenever a player unequips the kit.
 */
@FunctionalInterface
public interface UnequipKitHandler {
    void onUnequip(final ServerPlayer player) throws KitException;
}