package com.expansemc.matchpoint.api.kit.handler;

import com.expansemc.matchpoint.api.kit.KitException;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.event.item.inventory.InteractItemEvent;

@FunctionalInterface
public interface PrimaryClickKitHandler {
    void onPrimary(InteractItemEvent.Primary event, ServerPlayer player) throws KitException;
}