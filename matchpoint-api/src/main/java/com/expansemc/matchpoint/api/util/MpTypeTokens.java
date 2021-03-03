package com.expansemc.matchpoint.api.util;

import com.expansemc.matchpoint.api.kit.Kit;
import com.expansemc.matchpoint.api.team.Team;
import io.leangen.geantyref.TypeToken;
import org.spongepowered.api.data.value.Value;

public final class MpTypeTokens {

    public static final TypeToken<Kit> KIT_TOKEN = new TypeToken<>() {};

    public static final TypeToken<Value<Kit>> KIT_VALUE_TOKEN = new TypeToken<>() {};

    public static final TypeToken<Team> TEAM_TOKEN = new TypeToken<>() {};

    public static final TypeToken<Value<Team>> TEAM_VALUE_TOKEN = new TypeToken<>() {};

    private MpTypeTokens() {
    }
}