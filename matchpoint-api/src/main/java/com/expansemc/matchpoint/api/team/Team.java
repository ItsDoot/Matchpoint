package com.expansemc.matchpoint.api.team;

import com.expansemc.matchpoint.api.objective.Objective;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryValue;

public interface Team extends DefaultedRegistryValue {

    static Builder builder() {
        return Sponge.getGame().getBuilderProvider().provide(Builder.class);
    }

    Component displayName();

    TextColor color();

    TeamHandler handler();

    Objective objective();

    void setObjective(Objective objective);

    int score();

    void setScore(int score);

    interface Builder extends org.spongepowered.api.util.Builder<Team, Builder> {

        Builder displayName(Component displayName);

        Builder color(TextColor color);

        Builder handler(TeamHandler handler);

        Builder objective(Objective objective);

        Builder score(int score);
    }
}