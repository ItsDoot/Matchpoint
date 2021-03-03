package com.expansemc.matchpoint.plugin.kit;

import com.expansemc.matchpoint.api.kit.KitException;
import com.expansemc.matchpoint.api.kit.KitHandler;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.event.cause.entity.damage.source.DamageSource;
import org.spongepowered.api.event.entity.DamageEntityEvent;
import org.spongepowered.api.event.item.inventory.InteractItemEvent;

import java.util.List;
import java.util.ListIterator;

public final class SeqKitHandler implements KitHandler {

    private final List<KitHandler> handlers;
    public SeqKitHandler(final List<KitHandler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public void onEquip(final ServerPlayer player) throws KitException {
        // Equip in order.
        for (final KitHandler handler : this.handlers) {
            handler.onEquip(player);
        }
    }

    @Override
    public void onUnequip(final ServerPlayer player) throws KitException {
        // Unequip in reverse order.
        final ListIterator<KitHandler> iter = this.handlers.listIterator(this.handlers.size());
        while (iter.hasPrevious()) {
            iter.previous().onUnequip(player);
        }
    }

    @Override
    public void onPrimary(final InteractItemEvent.Primary event, final ServerPlayer player) throws KitException {
        for (final KitHandler handler : this.handlers) {
            handler.onPrimary(event, player);
        }
    }

    @Override
    public void onSecondary(final InteractItemEvent.Secondary event, final ServerPlayer player) throws KitException {
        for (final KitHandler handler : this.handlers) {
            handler.onSecondary(event, player);
        }
    }

    @Override
    public void onDamage(final DamageEntityEvent event, final DamageSource source, final ServerPlayer player) throws KitException {
        for (final KitHandler handler : this.handlers) {
            handler.onDamage(event, source, player);
        }
    }
}