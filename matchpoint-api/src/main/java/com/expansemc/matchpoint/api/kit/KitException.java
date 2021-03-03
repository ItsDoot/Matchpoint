package com.expansemc.matchpoint.api.kit;

import net.kyori.adventure.text.Component;
import org.spongepowered.api.util.ComponentMessageException;

import java.util.Objects;

public class KitException extends ComponentMessageException {

    public KitException(final Component message) {
        super(message);
    }

    public KitException(final Component message, final Throwable throwable) {
        super(message, throwable);
    }

    @Override
    public Component componentMessage() {
        return Objects.requireNonNull(super.componentMessage(), "componentMessage");
    }
}