package com.expansemc.matchpoint.plugin.kit;

import com.expansemc.matchpoint.api.kit.Kit;
import com.expansemc.matchpoint.api.kit.KitHandler;
import net.kyori.adventure.text.Component;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Objects;

public final class KitImpl implements Kit {

    private final Component displayName;
    private final KitHandler handler;

    public KitImpl(final Component displayName, final KitHandler handler) {
        this.displayName = displayName;
        this.handler = handler;
    }

    @Override
    public Component displayName() {
        return this.displayName;
    }

    @Override
    public KitHandler handler() {
        return this.handler;
    }

    public static final class BuilderImpl implements Kit.Builder {

        private @Nullable Component displayName;
        private KitHandler handler = KitHandler.empty();

        @Override
        public Builder displayName(final Component displayName) {
            this.displayName = Objects.requireNonNull(displayName, "displayName");
            return this;
        }

        @Override
        public Builder handler(final KitHandler handler) {
            this.handler = Objects.requireNonNull(handler, "handler");
            return this;
        }

        @Override
        public @NonNull Kit build() {
            return new KitImpl(
                    Objects.requireNonNull(this.displayName, "displayName"),
                    this.handler
            );
        }
    }
}