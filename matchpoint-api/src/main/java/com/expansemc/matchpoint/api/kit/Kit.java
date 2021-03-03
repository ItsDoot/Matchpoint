package com.expansemc.matchpoint.api.kit;

import net.kyori.adventure.text.Component;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryValue;

public interface Kit extends DefaultedRegistryValue {

    static Builder builder() {
        return Sponge.getGame().getBuilderProvider().provide(Builder.class);
    }

    Component displayName();

    KitHandler handler();

    interface Builder extends org.spongepowered.api.util.Builder<Kit, Builder> {

        Builder displayName(Component displayName);

        Builder handler(KitHandler handler);

        default Builder handlers(final KitHandler... handlers) {
            return this.handler(KitHandler.seq(handlers));
        }
    }
}