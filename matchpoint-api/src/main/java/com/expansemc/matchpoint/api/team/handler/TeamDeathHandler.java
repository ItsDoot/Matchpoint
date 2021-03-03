package com.expansemc.matchpoint.api.team.handler;

import com.expansemc.matchpoint.api.team.TeamException;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.event.entity.DestructEntityEvent;

@FunctionalInterface
public interface TeamDeathHandler {
    void onDeath(DestructEntityEvent.Death event, ServerPlayer player) throws TeamException;
}