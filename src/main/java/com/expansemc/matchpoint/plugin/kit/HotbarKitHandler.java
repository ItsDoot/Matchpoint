package com.expansemc.matchpoint.plugin.kit;

import com.expansemc.matchpoint.api.kit.KitException;
import com.expansemc.matchpoint.api.kit.KitHandler;
import net.kyori.adventure.text.Component;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;

import java.util.Map;

public final class HotbarKitHandler implements KitHandler {

    private final Map<Integer, ItemStackSnapshot> items;

    public HotbarKitHandler(final Map<Integer, ItemStackSnapshot> items) {
        this.items = items;
    }

    @Override
    public void onEquip(final ServerPlayer player) throws KitException {
        for (final Map.Entry<Integer, ItemStackSnapshot> entry : this.items.entrySet()) {
            if (!(entry.getKey() >= 0 && entry.getKey() <= 8)) {
                throw new KitException(Component.text("Invalid hotbar index: " + entry.getKey()));
            }

            player.getInventory().getHotbar().set(entry.getKey(), entry.getValue().createStack());
        }
    }

    @Override
    public void onUnequip(final ServerPlayer player) throws KitException {
        for (final Map.Entry<Integer, ItemStackSnapshot> entry : this.items.entrySet()) {
            if (!(entry.getKey() >= 0 && entry.getKey() <= 8)) {
                throw new KitException(Component.text("Invalid hotbar index: " + entry.getKey()));
            }

            player.getInventory().getHotbar().set(entry.getKey(), ItemStack.empty());
        }
    }
}