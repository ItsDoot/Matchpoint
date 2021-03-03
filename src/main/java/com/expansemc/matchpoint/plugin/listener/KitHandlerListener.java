package com.expansemc.matchpoint.plugin.listener;

import com.expansemc.matchpoint.api.data.MpKeys;
import com.expansemc.matchpoint.api.kit.KitException;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.cause.entity.damage.source.DamageSource;
import org.spongepowered.api.event.entity.DamageEntityEvent;
import org.spongepowered.api.event.entity.DestructEntityEvent;
import org.spongepowered.api.event.filter.Getter;
import org.spongepowered.api.event.filter.cause.First;
import org.spongepowered.api.event.item.inventory.InteractItemEvent;
import org.spongepowered.api.event.network.ServerSideConnectionEvent;

public final class KitHandlerListener {

    @Listener
    public void onDamage(final DamageEntityEvent event, @First final ServerPlayer player, @First final DamageSource source) {
        player.get(MpKeys.KIT).ifPresent(kit -> {
            try {
                kit.handler().onDamage(event, source, player);
            } catch (final KitException e) {
                player.sendMessage(e.componentMessage());
                event.setCancelled(true);
            }
        });
    }

    @Listener
    public void onDeath(final DestructEntityEvent.Death event, @Getter("getEntity") final ServerPlayer player) {
        player.get(MpKeys.KIT).ifPresent(kit -> {
            try {
                kit.handler().onDeath(event, player);
            } catch (final KitException e) {
                player.sendMessage(e.componentMessage());
                event.setCancelled(true);
            }
        });
    }

    @Listener
    public void onPrimaryClick(final InteractItemEvent.Primary event, @First final ServerPlayer player) {
        player.get(MpKeys.KIT).ifPresent(kit -> {
            try {
                kit.handler().onPrimary(event, player);
            } catch (final KitException e) {
                player.sendMessage(e.componentMessage());
            }
        });
    }

    @Listener
    public void onSecondaryClick(final InteractItemEvent.Secondary event, @First final ServerPlayer player) {
        player.get(MpKeys.KIT).ifPresent(kit -> {
            try {
                kit.handler().onSecondary(event, player);
            } catch (final KitException e) {
                player.sendMessage(e.componentMessage());
            }
        });
    }

    @Listener
    public void onDisconnect(final ServerSideConnectionEvent.Disconnect event, @Getter("getPlayer") final ServerPlayer player) {
        player.get(MpKeys.KIT).ifPresent(kit -> {
            try {
                kit.handler().onUnequip(player);
            } catch (final KitException e) {
                e.printStackTrace();
            }
        });
        player.remove(MpKeys.KIT);
    }
}