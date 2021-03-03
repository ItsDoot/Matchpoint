package com.expansemc.matchpoint.api.objective;

import com.expansemc.matchpoint.api.objective.handler.ObjectiveCompleteHandler;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;

public interface ObjectiveHandler extends ObjectiveCompleteHandler {

    @Override
    default void onComplete(final Objective objective, final ServerPlayer player) throws ObjectiveException {
    }

    static ObjectiveHandler empty() {
        return Sponge.getGame().getFactoryProvider().provide(Factory.class).empty();
    }

    static ObjectiveHandler onComplete(final ObjectiveCompleteHandler handler) {
        return Sponge.getGame().getFactoryProvider().provide(Factory.class).onComplete(handler);
    }

    static ObjectiveHandler seq(final Iterable<ObjectiveHandler> handlers) {
        return Sponge.getGame().getFactoryProvider().provide(Factory.class).seq(handlers);
    }

    static ObjectiveHandler seq(final ObjectiveHandler... handlers) {
        return Sponge.getGame().getFactoryProvider().provide(Factory.class).seq(handlers);
    }

    interface Factory {

        ObjectiveHandler empty();

        ObjectiveHandler onComplete(ObjectiveCompleteHandler handler);

        ObjectiveHandler seq(Iterable<ObjectiveHandler> handlers);

        ObjectiveHandler seq(ObjectiveHandler... handlers);
    }
}