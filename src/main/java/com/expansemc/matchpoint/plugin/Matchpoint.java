package com.expansemc.matchpoint.plugin;

import com.expansemc.matchpoint.api.data.MpKeys;
import com.expansemc.matchpoint.api.kit.Kit;
import com.expansemc.matchpoint.api.kit.KitHandler;
import com.expansemc.matchpoint.api.registry.MpRegistryTypes;
import com.expansemc.matchpoint.plugin.kit.KitHandlerFactory;
import com.expansemc.matchpoint.plugin.kit.KitImpl;
import com.expansemc.matchpoint.plugin.listener.KitHandlerListener;
import com.google.inject.Inject;
import org.apache.logging.log4j.Logger;
import org.spongepowered.api.Server;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataRegistration;
import org.spongepowered.api.data.persistence.DataQuery;
import org.spongepowered.api.data.persistence.DataStore;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.lifecycle.RegisterBuilderEvent;
import org.spongepowered.api.event.lifecycle.RegisterDataEvent;
import org.spongepowered.api.event.lifecycle.RegisterFactoryEvent;
import org.spongepowered.api.event.lifecycle.RegisterRegistryEvent;
import org.spongepowered.api.event.lifecycle.StartingEngineEvent;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.plugin.PluginContainer;
import org.spongepowered.plugin.jvm.Plugin;

@Plugin("matchpoint")
public final class Matchpoint implements com.expansemc.matchpoint.api.Matchpoint {

    private final Logger logger;
    private final PluginContainer container;

    @Inject
    public Matchpoint(final Logger logger, final PluginContainer container) {
        this.logger = logger;
        this.container = container;
    }

    @Listener
    public void onStartingServer(final StartingEngineEvent<Server> event) {
        Sponge.getEventManager().registerListeners(this.container, new KitHandlerListener());
    }

    @Listener
    public void onRegisterFactory(final RegisterFactoryEvent event) {
        this.logger.info("Registering factories...");

        event.register(com.expansemc.matchpoint.api.Matchpoint.class, this);
        event.register(KitHandler.Factory.class, new KitHandlerFactory());
    }

    @Listener
    public void onRegisterBuilder(final RegisterBuilderEvent event) {
        this.logger.info("Registering builders...");

        event.register(Kit.Builder.class, KitImpl.BuilderImpl::new);
    }

    @Listener
    public void onRegisterRegistry(final RegisterRegistryEvent event) {
        this.logger.info("Registering registries...");

        event.register(MpRegistryTypes.KIT.location(), true);
    }

    @SuppressWarnings("unchecked")
    @Listener
    public void onRegisterData(final RegisterDataEvent event) {
        final DataStore kitStore = DataStore.builder()
                .pluginData(MpKeys.KIT.getKey())
                .holder(User.class, Player.class)
                .key(MpKeys.KIT,
                        (view, kit) -> view.set(DataQuery.of("Kit"), kit.key(MpRegistryTypes.KIT)),
                        view -> view.getRegistryValue(DataQuery.of("Kit"), MpRegistryTypes.KIT))
                .build();

        final DataRegistration kitData = DataRegistration.builder()
                .dataKey(MpKeys.KIT).store(kitStore)
                .build();
        event.register(kitData);

        event.register(DataRegistration.of(MpKeys.UNDROPPABLE, ItemStack.class, ItemStackSnapshot.class));
    }

    @Override
    public PluginContainer implementation() {
        return this.container;
    }
}