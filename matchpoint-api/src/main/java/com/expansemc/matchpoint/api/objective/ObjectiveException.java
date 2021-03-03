package com.expansemc.matchpoint.api.objective;

import net.kyori.adventure.text.Component;
import org.spongepowered.api.util.ComponentMessageException;

import java.util.Objects;

public class ObjectiveException extends ComponentMessageException {

    public ObjectiveException(final Component message) {
        super(message);
    }

    public ObjectiveException(final Component message, final Throwable throwable) {
        super(message, throwable);
    }

    @Override
    public Component componentMessage() {
        return Objects.requireNonNull(super.componentMessage(), "componentMessage");
    }
}