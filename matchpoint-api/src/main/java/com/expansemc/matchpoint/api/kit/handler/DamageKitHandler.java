package com.expansemc.matchpoint.api.kit.handler;

import com.expansemc.matchpoint.api.kit.KitException;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.event.cause.entity.damage.source.DamageSource;
import org.spongepowered.api.event.entity.DamageEntityEvent;

/**
 * The damage handler is called whenever the player takes any damage.
 */
@FunctionalInterface
public interface DamageKitHandler {
    void onDamage(final DamageEntityEvent event, final DamageSource source, final ServerPlayer player) throws KitException;
}