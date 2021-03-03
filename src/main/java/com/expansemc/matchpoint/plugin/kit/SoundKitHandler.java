package com.expansemc.matchpoint.plugin.kit;

import com.expansemc.matchpoint.api.kit.KitHandler;
import net.kyori.adventure.sound.Sound;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;

import java.util.List;

public final class SoundKitHandler implements KitHandler {

    private final List<Sound> onEquip;
    private final List<Sound> onUnequip;

    public SoundKitHandler(final List<Sound> onEquip, final List<Sound> onUnequip) {
        this.onEquip = onEquip;
        this.onUnequip = onUnequip;
    }

    @Override
    public void onEquip(final ServerPlayer player) {
        for (final Sound sound : this.onEquip) {
            player.playSound(sound);
        }
    }

    @Override
    public void onUnequip(final ServerPlayer player) {
        for (final Sound sound : this.onUnequip) {
            player.playSound(sound);
        }
    }
}