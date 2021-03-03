package com.expansemc.matchpoint.plugin.listener;

import com.expansemc.matchpoint.api.data.MpKeys;
import com.expansemc.matchpoint.api.team.TeamException;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.entity.DestructEntityEvent;
import org.spongepowered.api.event.filter.Getter;
import org.spongepowered.api.event.network.ServerSideConnectionEvent;

public final class TeamHandlerListener {

    @Listener
    public void onDeath(final DestructEntityEvent.Death event, @Getter("getEntity") final ServerPlayer player) {
        player.get(MpKeys.TEAM).ifPresent(team -> {
            try {
                team.handler().onDeath(event, player);
            } catch (final TeamException e) {
                player.sendMessage(e.componentMessage());
                event.setCancelled(true);
            }
        });
    }

    @Listener
    public void onDisconnect(final ServerSideConnectionEvent.Disconnect event, @Getter("getPlayer") final ServerPlayer player) {
        player.get(MpKeys.TEAM).ifPresent(team -> {
            try {
                team.handler().onLeave(player);
            } catch (final TeamException e) {
                e.printStackTrace();
            }
        });
        player.remove(MpKeys.TEAM);
    }
}