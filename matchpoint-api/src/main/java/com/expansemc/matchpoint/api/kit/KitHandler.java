package com.expansemc.matchpoint.api.kit;

import com.expansemc.matchpoint.api.kit.handler.DamageKitHandler;
import com.expansemc.matchpoint.api.kit.handler.DeathKitHandler;
import com.expansemc.matchpoint.api.kit.handler.EquipKitHandler;
import com.expansemc.matchpoint.api.kit.handler.PrimaryClickKitHandler;
import com.expansemc.matchpoint.api.kit.handler.SecondaryClickKitHandler;
import com.expansemc.matchpoint.api.kit.handler.UnequipKitHandler;
import net.kyori.adventure.sound.Sound;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.event.cause.entity.damage.source.DamageSource;
import org.spongepowered.api.event.entity.DamageEntityEvent;
import org.spongepowered.api.event.entity.DestructEntityEvent;
import org.spongepowered.api.event.item.inventory.InteractItemEvent;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;

import java.util.Map;

public interface KitHandler extends
        DamageKitHandler, DeathKitHandler,
        EquipKitHandler, UnequipKitHandler,
        PrimaryClickKitHandler, SecondaryClickKitHandler {

    @Override
    default void onEquip(final ServerPlayer player) throws KitException {
    }

    @Override
    default void onUnequip(final ServerPlayer player) throws KitException {
    }

    @Override
    default void onPrimary(final InteractItemEvent.Primary event, final ServerPlayer player) throws KitException {
    }

    @Override
    default void onSecondary(final InteractItemEvent.Secondary event, final ServerPlayer player) throws KitException {
    }

    @Override
    default void onDamage(final DamageEntityEvent event, final DamageSource source, final ServerPlayer player) throws KitException {
    }

    @Override
    default void onDeath(final DestructEntityEvent.Death event, final ServerPlayer player) throws KitException {
    }

    static KitHandler empty() {
        return Sponge.getGame().getFactoryProvider().provide(Factory.class).empty();
    }

    static KitHandler onDamage(final DamageKitHandler handler) {
        return Sponge.getGame().getFactoryProvider().provide(Factory.class).onDamage(handler);
    }

    static KitHandler onPrimary(final PrimaryClickKitHandler handler) {
        return Sponge.getGame().getFactoryProvider().provide(Factory.class).onPrimary(handler);
    }

    static KitHandler onSecondary(final SecondaryClickKitHandler handler) {
        return Sponge.getGame().getFactoryProvider().provide(Factory.class).onSecondary(handler);
    }

    static KitHandler seq(final Iterable<KitHandler> handlers) {
        return Sponge.getGame().getFactoryProvider().provide(Factory.class).seq(handlers);
    }

    static KitHandler seq(final KitHandler... handlers) {
        return Sponge.getGame().getFactoryProvider().provide(Factory.class).seq(handlers);
    }

    static KitHandler armor(final @Nullable ItemStackSnapshot head, final @Nullable ItemStackSnapshot chest,
                            final @Nullable ItemStackSnapshot legs, final @Nullable ItemStackSnapshot feet) {
        return Sponge.getGame().getFactoryProvider().provide(Factory.class).armor(head, chest, legs, feet);
    }

    static KitHandler hotbar(final Map<Integer, ItemStackSnapshot> items) {
        return Sponge.getGame().getFactoryProvider().provide(Factory.class).hotbar(items);
    }

    static KitHandler potions(final Iterable<PotionEffect> effects) {
        return Sponge.getGame().getFactoryProvider().provide(Factory.class).potions(effects);
    }

    static KitHandler potions(final PotionEffect... effects) {
        return Sponge.getGame().getFactoryProvider().provide(Factory.class).potions(effects);
    }

    static KitHandler sounds(final Iterable<Sound> onEquip, final Iterable<Sound> onUnequip) {
        return Sponge.getGame().getFactoryProvider().provide(Factory.class).soundEffects(onEquip, onUnequip);
    }

    interface Factory {

        KitHandler empty();

        KitHandler onDamage(DamageKitHandler handler);

        KitHandler onPrimary(PrimaryClickKitHandler handler);

        KitHandler onSecondary(SecondaryClickKitHandler handler);

        KitHandler seq(Iterable<KitHandler> handlers);

        KitHandler seq(KitHandler... handlers);

        KitHandler armor(@Nullable ItemStackSnapshot head, @Nullable ItemStackSnapshot chest,
                         @Nullable ItemStackSnapshot legs, @Nullable ItemStackSnapshot feet);

        KitHandler hotbar(Map<Integer, ItemStackSnapshot> items);

        KitHandler potions(Iterable<PotionEffect> effects);

        KitHandler potions(PotionEffect... effects);

        KitHandler soundEffects(Iterable<Sound> onEquip, Iterable<Sound> onUnequip);
    }
}