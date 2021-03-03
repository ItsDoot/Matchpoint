package com.expansemc.matchpoint.api;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.plugin.PluginContainer;

public interface Matchpoint {

    static Matchpoint get() {
        return Sponge.getGame().getFactoryProvider().provide(Matchpoint.class);
    }

    PluginContainer implementation();

    static ResourceKey key(final String value) {
        return ResourceKey.of(Matchpoint.get().implementation(), value);
    }
}