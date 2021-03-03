package com.expansemc.matchpoint.plugin.kit;

import com.expansemc.matchpoint.api.kit.KitException;
import com.expansemc.matchpoint.api.kit.KitHandler;
import com.expansemc.matchpoint.api.kit.handler.DamageKitHandler;
import com.expansemc.matchpoint.api.kit.handler.PrimaryClickKitHandler;
import com.expansemc.matchpoint.api.kit.handler.SecondaryClickKitHandler;
import com.google.common.collect.ImmutableList;
import net.kyori.adventure.sound.Sound;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.event.cause.entity.damage.source.DamageSource;
import org.spongepowered.api.event.entity.DamageEntityEvent;
import org.spongepowered.api.event.item.inventory.InteractItemEvent;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class KitHandlerFactory implements KitHandler.Factory {

    @Override
    public KitHandler empty() {
        return EmptyKitHandler.INSTANCE;
    }

    @Override
    public KitHandler onDamage(final DamageKitHandler handler) {
        Objects.requireNonNull(handler, "handler");

        return new KitHandler() {
            @Override
            public void onDamage(final DamageEntityEvent event, final DamageSource source, final ServerPlayer player) throws KitException {
                handler.onDamage(event, source, player);
            }
        };
    }

    @Override
    public KitHandler onPrimary(final PrimaryClickKitHandler handler) {
        return new KitHandler() {
            @Override
            public void onPrimary(final InteractItemEvent.Primary event, final ServerPlayer player) throws KitException {
                handler.onPrimary(event, player);
            }
        };
    }

    @Override
    public KitHandler onSecondary(final SecondaryClickKitHandler handler) {
        return new KitHandler() {
            @Override
            public void onSecondary(final InteractItemEvent.Secondary event, final ServerPlayer player) throws KitException {
                handler.onSecondary(event, player);
            }
        };
    }

    @Override
    public KitHandler seq(final Iterable<KitHandler> handlers) {
        return new SeqKitHandler(ImmutableList.copyOf(Objects.requireNonNull(handlers, "handlers")));
    }

    @Override
    public KitHandler seq(final KitHandler... handlers) {
        return new SeqKitHandler(List.of(Objects.requireNonNull(handlers, "handlers")));
    }

    @Override
    public KitHandler armor(final @Nullable ItemStackSnapshot head, final @Nullable ItemStackSnapshot chest,
                            final @Nullable ItemStackSnapshot legs, final @Nullable ItemStackSnapshot feet) {
        return new ArmorKitHandler(head, chest, legs, feet);
    }

    @Override
    public KitHandler hotbar(final Map<Integer, ItemStackSnapshot> items) {
        return new HotbarKitHandler(Objects.requireNonNull(items, "items"));
    }

    @Override
    public KitHandler potions(final Iterable<PotionEffect> effects) {
        return new PotionEffectKitHandler(ImmutableList.copyOf(Objects.requireNonNull(effects, "effects")));
    }

    @Override
    public KitHandler potions(final PotionEffect... effects) {
        return new PotionEffectKitHandler(List.of(Objects.requireNonNull(effects, "effects")));
    }

    @Override
    public KitHandler soundEffects(final Iterable<Sound> onEquip, final Iterable<Sound> onUnequip) {
        return new SoundKitHandler(
                ImmutableList.copyOf(Objects.requireNonNull(onEquip, "onEquip")),
                ImmutableList.copyOf(Objects.requireNonNull(onUnequip, "onUnequip"))
        );
    }
}