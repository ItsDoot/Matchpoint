package com.expansemc.matchpoint.plugin.kit;

import com.expansemc.matchpoint.api.kit.KitHandler;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.item.inventory.equipment.EquipmentTypes;

public final class ArmorKitHandler implements KitHandler {

    private final @Nullable ItemStackSnapshot head;
    private final @Nullable ItemStackSnapshot chest;
    private final @Nullable ItemStackSnapshot legs;
    private final @Nullable ItemStackSnapshot feet;

    public ArmorKitHandler(final @Nullable ItemStackSnapshot head, final @Nullable ItemStackSnapshot chest,
                           final @Nullable ItemStackSnapshot legs, final @Nullable ItemStackSnapshot feet) {
        this.head = head;
        this.chest = chest;
        this.legs = legs;
        this.feet = feet;
    }

    @Override
    public void onEquip(final ServerPlayer player) {
        final ItemStack head = this.head != null ? this.head.createStack() : ItemStack.empty();
        final ItemStack chest = this.chest != null ? this.chest.createStack() : ItemStack.empty();
        final ItemStack legs = this.legs != null ? this.legs.createStack() : ItemStack.empty();
        final ItemStack feet = this.feet != null ? this.feet.createStack() : ItemStack.empty();

        player.equip(EquipmentTypes.HEAD, head);
        player.equip(EquipmentTypes.CHEST, chest);
        player.equip(EquipmentTypes.LEGS, legs);
        player.equip(EquipmentTypes.FEET, feet);
        // TODO: throw exception for failed inventory modification?
    }

    @Override
    public void onUnequip(final ServerPlayer player) {
        player.equip(EquipmentTypes.HEAD, ItemStack.empty());
        player.equip(EquipmentTypes.CHEST, ItemStack.empty());
        player.equip(EquipmentTypes.LEGS, ItemStack.empty());
        player.equip(EquipmentTypes.FEET, ItemStack.empty());
        // TODO: throw exception for failed inventory modification?
    }
}