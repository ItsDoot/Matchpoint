package com.expansemc.matchpoint.api.team;

import net.kyori.adventure.text.Component;
import org.spongepowered.api.util.ComponentMessageException;

import java.util.Objects;

public class TeamException extends ComponentMessageException {

    public TeamException(final Component message) {
        super(message);
    }

    public TeamException(final Component message, final Throwable throwable) {
        super(message, throwable);
    }

    @Override
    public Component componentMessage() {
        return Objects.requireNonNull(super.componentMessage(), "componentMessage");
    }
}