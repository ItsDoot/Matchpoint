package com.expansemc.matchpoint.kitpvp.kit;

import com.expansemc.matchpoint.api.kit.Kit;
import com.expansemc.matchpoint.api.kit.KitHandler;
import net.kyori.adventure.text.Component;
import org.spongepowered.api.data.Keys;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.effect.potion.PotionEffectTypes;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.enchantment.Enchantment;
import org.spongepowered.api.item.enchantment.EnchantmentTypes;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;

import java.util.List;
import java.util.Map;

public final class KitKnight {

    private static final List<Enchantment> ARMOR_ENCHANTMENTS = List.of(
            Enchantment.of(EnchantmentTypes.PROTECTION, 3)
    );

    private static final ItemStackSnapshot HEAD = ItemStack.builder()
            .itemType(ItemTypes.NETHERITE_HELMET)
            .add(Keys.IS_UNBREAKABLE, true)
            .add(Keys.APPLIED_ENCHANTMENTS, ARMOR_ENCHANTMENTS)
            .build().createSnapshot();

    private static final ItemStackSnapshot CHEST = ItemStack.builder()
            .itemType(ItemTypes.DIAMOND_CHESTPLATE)
            .add(Keys.IS_UNBREAKABLE, true)
            .add(Keys.APPLIED_ENCHANTMENTS, ARMOR_ENCHANTMENTS)
            .build().createSnapshot();

    private static final ItemStackSnapshot LEGS = ItemStack.builder()
            .itemType(ItemTypes.DIAMOND_LEGGINGS)
            .add(Keys.IS_UNBREAKABLE, true)
            .add(Keys.APPLIED_ENCHANTMENTS, ARMOR_ENCHANTMENTS)
            .build().createSnapshot();

    private static final ItemStackSnapshot FEET = ItemStack.builder()
            .itemType(ItemTypes.NETHERITE_BOOTS)
            .add(Keys.IS_UNBREAKABLE, true)
            .add(Keys.APPLIED_ENCHANTMENTS, ARMOR_ENCHANTMENTS)
            .build().createSnapshot();

    private static final ItemStackSnapshot SWORD = ItemStack.builder()
            .itemType(ItemTypes.IRON_SWORD)
            .add(Keys.IS_UNBREAKABLE, true)
            .build().createSnapshot();

    private static final PotionEffect SLOWNESS = PotionEffect.builder()
            .potionType(PotionEffectTypes.SLOWNESS)
            .amplifier(1)
            .duration(Integer.MAX_VALUE)
            .build();

    public static final Kit KIT = Kit.builder()
            .displayName(Component.text("Knight"))
            .handlers(
                    KitHandler.armor(HEAD, CHEST, LEGS, FEET),
                    KitHandler.hotbar(Map.of(0, SWORD)),
                    KitHandler.potions(SLOWNESS),
                    KitCommon.SOUND_HANDLER
            )
            .build();

    private KitKnight() {
    }
}