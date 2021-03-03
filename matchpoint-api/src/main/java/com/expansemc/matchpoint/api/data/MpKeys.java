package com.expansemc.matchpoint.api.data;

import com.expansemc.matchpoint.api.Matchpoint;
import com.expansemc.matchpoint.api.kit.Kit;
import com.expansemc.matchpoint.api.team.Team;
import com.expansemc.matchpoint.api.util.MpTypeTokens;
import org.spongepowered.api.data.Key;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.util.TypeTokens;

public final class MpKeys {

    /**
     * The current {@link Kit} of a {@link Player}.
     */
    public static final Key<Value<Kit>> KIT = Key.of(Matchpoint.key("kit"), MpTypeTokens.KIT_VALUE_TOKEN);

    /**
     * The {@link Team} that a {@link Player} is on.
     */
    public static final Key<Value<Team>> TEAM = Key.of(Matchpoint.key("team"), MpTypeTokens.TEAM_VALUE_TOKEN);

    /**
     * Whether an {@link ItemStack} in a {@link Player}'s inventory can be dropped.
     */
    public static final Key<Value<Boolean>> UNDROPPABLE = Key.of(Matchpoint.key("undroppable"), TypeTokens.BOOLEAN_VALUE_TOKEN);

    private MpKeys() {
    }
}