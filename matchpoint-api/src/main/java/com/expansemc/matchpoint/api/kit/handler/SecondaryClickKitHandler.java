package com.expansemc.matchpoint.api.kit.handler;

import com.expansemc.matchpoint.api.kit.KitException;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.event.item.inventory.InteractItemEvent;

@FunctionalInterface
public interface SecondaryClickKitHandler {
    void onSecondary(InteractItemEvent.Secondary event, ServerPlayer player) throws KitException;
}