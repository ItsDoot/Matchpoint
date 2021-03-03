package com.expansemc.matchpoint.api.team.handler;

import com.expansemc.matchpoint.api.objective.Objective;
import com.expansemc.matchpoint.api.team.TeamException;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;

@FunctionalInterface
public interface TeamScoreHandler {
    void onScore(final Objective objective, final ServerPlayer player) throws TeamException;
}