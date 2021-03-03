package com.expansemc.matchpoint.kitpvp.command;

import com.expansemc.matchpoint.api.data.MpKeys;
import com.expansemc.matchpoint.api.kit.Kit;
import com.expansemc.matchpoint.api.kit.KitException;
import com.expansemc.matchpoint.api.registry.MpRegistryTypes;
import com.expansemc.matchpoint.api.util.MpTypeTokens;
import net.kyori.adventure.text.Component;
import org.spongepowered.api.command.Command;
import org.spongepowered.api.command.CommandExecutor;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.exception.CommandException;
import org.spongepowered.api.command.parameter.CommandContext;
import org.spongepowered.api.command.parameter.Parameter;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;

import java.util.Optional;

public final class CommandKit implements CommandExecutor {

    private static final Parameter.Value<Kit> KIT_PARAMETER =
            Parameter.registryElement(MpTypeTokens.KIT_TOKEN, MpRegistryTypes.KIT)
                    .setKey("kit")
                    .optional()
                    .build();

    public static final Command.Parameterized COMMAND = Command.builder()
            .parameter(KIT_PARAMETER)
            .setExecutor(new CommandKit())
            .build();

    @Override
    public CommandResult execute(final CommandContext context) throws CommandException {
        final ServerPlayer player = context.getCause().first(ServerPlayer.class)
                .orElseThrow(() -> new CommandException(Component.text("Must be a player to use this command.")));

        final Optional<Kit> kitOpt = context.getOne(KIT_PARAMETER);
        final Optional<Kit> oldKitOpt = player.get(MpKeys.KIT);

        if (kitOpt.isPresent()) {
            final Kit kit = kitOpt.get();

            if (oldKitOpt.isPresent()) {
                final Kit oldKit = oldKitOpt.get();
                try {
                    oldKit.handler().onUnequip(player);
                } catch (final KitException e) {
                    throw new CommandException(Component.text("Encountered an error while removing old kit"), e);
                }
                player.sendMessage(Component.text("Unequipped Kit: ").append(oldKit.displayName()));
            }

            try {
                kit.handler().onEquip(player);
                player.offer(MpKeys.KIT, kit);
            } catch (final KitException e) {
                throw new CommandException(Component.text("Encountered an error while equipping new kit"), e);
            }
            player.sendMessage(Component.text("Equipped Kit: ").append(kit.displayName()));

        } else if (oldKitOpt.isPresent()) {
            final Kit oldKit = oldKitOpt.get();
            player.sendMessage(Component.text("Current Kit: ").append(oldKit.displayName()));

        } else {
            player.sendMessage(Component.text("Current Kit: <none>"));
        }

        return CommandResult.success();
    }
}