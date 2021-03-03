package com.expansemc.matchpoint.api.team;

import com.expansemc.matchpoint.api.objective.Objective;
import com.expansemc.matchpoint.api.team.handler.TeamDeathHandler;
import com.expansemc.matchpoint.api.team.handler.TeamJoinHandler;
import com.expansemc.matchpoint.api.team.handler.TeamLeaveHandler;
import com.expansemc.matchpoint.api.team.handler.TeamScoreHandler;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.event.entity.DestructEntityEvent;

public interface TeamHandler extends TeamDeathHandler, TeamJoinHandler, TeamLeaveHandler, TeamScoreHandler {

    @Override
    default void onDeath(final DestructEntityEvent.Death event, final ServerPlayer player) throws TeamException {
    }

    @Override
    default void onJoin(final ServerPlayer player) throws TeamException {
    }

    @Override
    default void onLeave(final ServerPlayer player) throws TeamException {
    }

    @Override
    default void onScore(final Objective objective, final ServerPlayer player) throws TeamException {
    }

    static TeamHandler empty() {
        return Sponge.getGame().getFactoryProvider().provide(Factory.class).empty();
    }

    static TeamHandler seq(final Iterable<TeamHandler> handlers) {
        return Sponge.getGame().getFactoryProvider().provide(Factory.class).seq(handlers);
    }

    static TeamHandler seq(final TeamHandler... handlers) {
        return Sponge.getGame().getFactoryProvider().provide(Factory.class).seq(handlers);
    }

    interface Factory {

        TeamHandler empty();

        TeamHandler seq(Iterable<TeamHandler> handlers);

        TeamHandler seq(TeamHandler... handlers);
    }
}