package com.expansemc.matchpoint.kitpvp.kit;

import com.expansemc.matchpoint.api.data.MpKeys;
import com.expansemc.matchpoint.api.kit.KitHandler;
import net.kyori.adventure.sound.Sound;
import org.spongepowered.api.data.Keys;
import org.spongepowered.api.effect.sound.SoundTypes;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public final class KitCommon {

    public static final KitHandler SOUND_HANDLER = KitHandler.sounds(
            List.of(
                    Sound.sound(SoundTypes.ENTITY_PLAYER_LEVELUP, Sound.Source.PLAYER, 1.0f, 2.0f)
            ),
            List.of()
    );

    public static ItemStackSnapshot item(final Consumer<ItemStack.Builder> consumer) {
        final ItemStack.Builder builder = ItemStack.builder();

        builder.add(Keys.IS_UNBREAKABLE, true);
        builder.add(MpKeys.UNDROPPABLE, true);

        consumer.accept(builder);

        return builder.build().createSnapshot();
    }

    public static ItemStackSnapshot item(final Supplier<ItemType> type) {
        return item(builder -> builder.itemType(type));
    }

    public static ItemStackSnapshot item(final ItemType type) {
        return item(builder -> builder.itemType(type));
    }

    private KitCommon() {
    }
}