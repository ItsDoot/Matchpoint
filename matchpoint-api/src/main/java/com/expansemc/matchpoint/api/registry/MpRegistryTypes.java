package com.expansemc.matchpoint.api.registry;

import com.expansemc.matchpoint.api.Matchpoint;
import com.expansemc.matchpoint.api.kit.Kit;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryType;
import org.spongepowered.api.registry.RegistryRoots;
import org.spongepowered.api.registry.RegistryType;

public final class MpRegistryTypes {

    public static final DefaultedRegistryType<Kit> KIT = registryType("kit");

    private static <T> DefaultedRegistryType<T> registryType(final String value) {
        return RegistryType.of(RegistryRoots.SPONGE, Matchpoint.key(value))
                .asDefaultedType(() -> Sponge.getGame().registries());
    }

    private MpRegistryTypes() {
    }
}