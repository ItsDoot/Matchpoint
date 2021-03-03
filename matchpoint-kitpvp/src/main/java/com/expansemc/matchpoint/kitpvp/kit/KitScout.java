package com.expansemc.matchpoint.kitpvp.kit;

import com.expansemc.matchpoint.api.kit.Kit;
import com.expansemc.matchpoint.api.kit.KitHandler;
import net.kyori.adventure.text.Component;
import org.spongepowered.api.data.Keys;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.effect.potion.PotionEffectTypes;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;

import java.util.Map;

public final class KitScout {

    private static final ItemStackSnapshot HEAD = ItemStack.builder()
            .itemType(ItemTypes.IRON_HELMET)
            .add(Keys.IS_UNBREAKABLE, true)
            .build().createSnapshot();

    private static final ItemStackSnapshot CHEST = ItemStack.builder()
            .itemType(ItemTypes.LEATHER_CHESTPLATE)
            .add(Keys.IS_UNBREAKABLE, true)
            .build().createSnapshot();

    private static final ItemStackSnapshot SWORD = ItemStack.builder()
            .itemType(ItemTypes.IRON_SWORD)
            .add(Keys.IS_UNBREAKABLE, true)
            .build().createSnapshot();

    private static final PotionEffect SPEED = PotionEffect.builder()
            .potionType(PotionEffectTypes.SPEED)
            .amplifier(2)
            .duration(Integer.MAX_VALUE)
            .build();

    public static final Kit KIT = Kit.builder()
            .displayName(Component.text("Scout"))
            .handlers(
                    KitHandler.armor(HEAD, CHEST, null, null),
                    KitHandler.hotbar(Map.of(0, SWORD)),
                    KitHandler.potions(SPEED),
                    KitCommon.SOUND_HANDLER
            )
            .build();
}