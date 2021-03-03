package com.expansemc.matchpoint.kitpvp;

import com.expansemc.matchpoint.api.registry.MpRegistryTypes;
import com.expansemc.matchpoint.kitpvp.command.CommandKit;
import com.expansemc.matchpoint.kitpvp.kit.KitDragoon;
import com.expansemc.matchpoint.kitpvp.kit.KitKnight;
import com.expansemc.matchpoint.kitpvp.kit.KitScout;
import com.google.inject.Inject;
import org.apache.logging.log4j.Logger;
import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Server;
import org.spongepowered.api.command.Command;
import org.spongepowered.api.data.Keys;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.lifecycle.RegisterCommandEvent;
import org.spongepowered.api.event.lifecycle.RegisterRegistryValueEvent;
import org.spongepowered.api.event.lifecycle.StartedEngineEvent;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.enchantment.Enchantment;
import org.spongepowered.api.item.enchantment.EnchantmentTypes;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.plugin.PluginContainer;
import org.spongepowered.plugin.jvm.Plugin;

import java.util.List;

@Plugin("kitpvp")
public final class KitPvP {

    private final Logger logger;
    private final PluginContainer container;

    @Inject
    public KitPvP(final Logger logger, final PluginContainer container) {
        this.logger = logger;
        this.container = container;
    }

    @Listener
    public void onStarted(final StartedEngineEvent<Server> event) {
        this.logger.info("Server started.");

        final ItemStack itemA = ItemStack.builder()
                .itemType(ItemTypes.NETHERITE_HELMET)
                .add(Keys.IS_UNBREAKABLE, true)
                .add(Keys.APPLIED_ENCHANTMENTS, List.of(Enchantment.of(EnchantmentTypes.PROTECTION, 3)))
                .build();
        final ItemStackSnapshot itemSnapshot = itemA.createSnapshot();
        final ItemStack itemB = itemSnapshot.createStack();

        this.logger.info("itemA: " + itemA.getValues());
        this.logger.info("itemSnapshot: " + itemSnapshot.getValues());
        this.logger.info("itemB: " + itemB.getValues());
    }

    @Listener
    public void onRegisterCommand(final RegisterCommandEvent<Command.Parameterized> event) {
        this.logger.info("Registering commands...");

        event.register(this.container, CommandKit.COMMAND, "kit");
    }

    @Listener
    public void onRegisterRegistryValue(final RegisterRegistryValueEvent event) {
        this.logger.info("Registering kits...");

        event.registry(MpRegistryTypes.KIT)
                .register(ResourceKey.of(this.container, "dragoon"), KitDragoon.KIT)
                .register(ResourceKey.of(this.container, "knight"), KitKnight.KIT)
                .register(ResourceKey.of(this.container, "scout"), KitScout.KIT);
    }
}