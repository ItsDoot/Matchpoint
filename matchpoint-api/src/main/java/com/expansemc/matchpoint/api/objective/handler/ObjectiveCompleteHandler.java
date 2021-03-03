package com.expansemc.matchpoint.api.objective.handler;

import com.expansemc.matchpoint.api.data.MpKeys;
import com.expansemc.matchpoint.api.objective.Objective;
import com.expansemc.matchpoint.api.objective.ObjectiveException;
import com.expansemc.matchpoint.api.team.Team;
import com.expansemc.matchpoint.api.team.TeamException;
import net.kyori.adventure.text.Component;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;

@FunctionalInterface
public interface ObjectiveCompleteHandler {
    void onComplete(Objective objective, ServerPlayer player) throws ObjectiveException;

    static ObjectiveCompleteHandler scoreForTeam(final boolean teamOnly) {
        return (objective, player) -> {
            final @Nullable Team team = player.getOrNull(MpKeys.TEAM);

            if (team != null) {
                try {
                    team.handler().onScore(objective, player);
                } catch (final TeamException e) {
                    throw new ObjectiveException(Component.text("Error while scoring for team ").append(team.displayName()), e);
                }
            } else if (teamOnly) {
                throw new ObjectiveException(Component.text("You must be in a team to score."));
            }
        };
    }
}