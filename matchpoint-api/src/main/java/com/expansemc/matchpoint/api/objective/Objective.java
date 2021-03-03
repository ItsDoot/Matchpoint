package com.expansemc.matchpoint.api.objective;

import net.kyori.adventure.text.Component;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryValue;

public interface Objective extends DefaultedRegistryValue {

    static Builder builder() {
        return Sponge.getGame().getBuilderProvider().provide(Builder.class);
    }

    Component displayName();

    ObjectiveHandler handler();

    interface Builder extends org.spongepowered.api.util.Builder<Objective, Builder> {

        Builder displayName(Component displayName);

        Builder handler(ObjectiveHandler handler);

        default Builder handlers(final ObjectiveHandler... handlers) {
            return this.handler(ObjectiveHandler.seq(handlers));
        }
    }
}