package com.expansemc.matchpoint.api.team.handler;

import com.expansemc.matchpoint.api.team.TeamException;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;

@FunctionalInterface
public interface TeamLeaveHandler {
    void onLeave(final ServerPlayer player) throws TeamException;
}