package com.expansemc.matchpoint.plugin.listener;

import com.expansemc.matchpoint.api.data.MpKeys;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.item.inventory.DropItemEvent;

public class MiscAttributeListener {

    @Listener
    public void onItemDrop(final DropItemEvent.Pre event) {
        // Don't drop undroppable items.
        event.getDroppedItems().removeIf(item -> item.getOrElse(MpKeys.UNDROPPABLE, false));
    }
}