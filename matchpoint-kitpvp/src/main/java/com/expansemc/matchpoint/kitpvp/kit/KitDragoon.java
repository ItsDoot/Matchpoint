package com.expansemc.matchpoint.kitpvp.kit;

import com.expansemc.matchpoint.api.kit.Kit;
import com.expansemc.matchpoint.api.kit.KitException;
import com.expansemc.matchpoint.api.kit.KitHandler;
import net.kyori.adventure.text.Component;
import org.spongepowered.api.data.Keys;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.effect.potion.PotionEffectTypes;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.event.cause.entity.damage.DamageTypes;
import org.spongepowered.api.event.cause.entity.damage.source.DamageSource;
import org.spongepowered.api.event.entity.DamageEntityEvent;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.enchantment.Enchantment;
import org.spongepowered.api.item.enchantment.EnchantmentTypes;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;

import java.util.List;
import java.util.Map;

public final class KitDragoon {

    private static final ItemStackSnapshot HEAD = ItemStack.builder()
            .itemType(ItemTypes.IRON_HELMET)
            .add(Keys.IS_UNBREAKABLE, true)
            .build().createSnapshot();

    private static final ItemStackSnapshot CHEST = ItemStack.builder()
            .itemType(ItemTypes.IRON_CHESTPLATE)
            .add(Keys.IS_UNBREAKABLE, true)
            .build().createSnapshot();

    private static final ItemStackSnapshot LEGS = ItemStack.builder()
            .itemType(ItemTypes.IRON_LEGGINGS)
            .add(Keys.IS_UNBREAKABLE, true)
            .build().createSnapshot();

    private static final ItemStackSnapshot FEET = ItemStack.builder()
            .itemType(ItemTypes.IRON_BOOTS)
            .add(Keys.IS_UNBREAKABLE, true)
            .build().createSnapshot();

    private static final ItemStackSnapshot SWORD = ItemStack.builder()
            .itemType(ItemTypes.IRON_SWORD)
            .add(Keys.IS_UNBREAKABLE, true)
            .add(Keys.APPLIED_ENCHANTMENTS, List.of(Enchantment.of(EnchantmentTypes.KNOCKBACK, 1)))
            .build().createSnapshot();

    private static final PotionEffect JUMP_BOOST = PotionEffect.builder()
            .potionType(PotionEffectTypes.JUMP_BOOST)
            .amplifier(1)
            .duration(Integer.MAX_VALUE)
            .build();

    public static final Kit KIT = Kit.builder()
            .displayName(Component.text("Dragoon"))
            .handlers(
                    KitHandler.armor(HEAD, CHEST, LEGS, FEET),
                    KitHandler.hotbar(Map.of(0, SWORD)),
                    KitHandler.potions(JUMP_BOOST),
                    KitHandler.onDamage(KitDragoon::preventFallDamage),
                    KitCommon.SOUND_HANDLER
            )
            .build();

    private static void preventFallDamage(final DamageEntityEvent event, final DamageSource source, final ServerPlayer player) throws KitException {
        if (source.getType().equals(DamageTypes.FALL.get())) {
            event.setCancelled(true);
        }
    }

    private KitDragoon() {
    }
}