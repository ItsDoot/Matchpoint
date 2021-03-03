package com.expansemc.matchpoint.plugin.kit;

import com.expansemc.matchpoint.api.kit.KitHandler;
import org.spongepowered.api.data.Keys;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.effect.potion.PotionEffectType;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;

import java.util.List;
import java.util.stream.Collectors;

public final class PotionEffectKitHandler implements KitHandler {

    private final List<PotionEffect> effects;
    private final List<PotionEffectType> effectTypes;

    public PotionEffectKitHandler(final List<PotionEffect> effects) {
        this.effects = effects;
        this.effectTypes = this.effects.stream()
                .map(PotionEffect::getType)
                .collect(Collectors.toList());
    }

    @Override
    public void onEquip(final ServerPlayer player) {
        player.offerAll(Keys.POTION_EFFECTS, this.effects);
        // TODO: throw exception for offer failure?
    }

    @Override
    public void onUnequip(final ServerPlayer player) {
        player.remove(Keys.POTION_EFFECTS);
        // TODO: throw exception for remove failure?
    }
}