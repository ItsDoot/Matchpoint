package com.expansemc.matchpoint.api.event.kit;

import org.spongepowered.api.entity.living.player.Player;

public interface UnequipKitEvent extends KitEvent {

    Player player();
}