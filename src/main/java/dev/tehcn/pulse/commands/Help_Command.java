package dev.tehcn.pulse.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import dev.tehcn.pulse.hacks.Help;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;

import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal;

public class Help_Command {
    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher) {
        dispatcher.register(literal("pulse").executes(ctx -> run(ctx.getSource())));
    }

    public static int run(FabricClientCommandSource source) {
        Help.run();
        return Command.SINGLE_SUCCESS;
    }
}
