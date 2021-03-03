package com.expansemc.matchpoint.plugin.kit;

import com.expansemc.matchpoint.api.kit.KitHandler;

public final class EmptyKitHandler implements KitHandler {

    public static final EmptyKitHandler INSTANCE = new EmptyKitHandler();

    private EmptyKitHandler() {
    }
}