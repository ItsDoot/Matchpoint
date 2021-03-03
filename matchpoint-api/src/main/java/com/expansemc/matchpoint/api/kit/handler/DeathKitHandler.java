package com.expansemc.matchpoint.api.kit.handler;

import com.expansemc.matchpoint.api.kit.KitException;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.event.entity.DestructEntityEvent;

public interface DeathKitHandler {
    void onDeath(DestructEntityEvent.Death event, ServerPlayer player) throws KitException;
}