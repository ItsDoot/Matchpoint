package com.expansemc.matchpoint.api.event.kit;

import org.spongepowered.api.entity.living.player.Player;

public interface EquipKitEvent extends KitEvent {

    Player player();
}