package com.expansemc.matchpoint.api.team.handler;

import com.expansemc.matchpoint.api.team.TeamException;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;

@FunctionalInterface
public interface TeamJoinHandler {
    void onJoin(final ServerPlayer player) throws TeamException;
}