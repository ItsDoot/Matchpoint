package com.expansemc.matchpoint.api.event.kit;

import com.expansemc.matchpoint.api.kit.Kit;
import org.spongepowered.api.event.Event;

public interface KitEvent extends Event {

    Kit kit();
}