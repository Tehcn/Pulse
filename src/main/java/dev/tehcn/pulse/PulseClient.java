package dev.tehcn.pulse;

import com.mojang.brigadier.CommandDispatcher;
import dev.tehcn.pulse.commands.Help_Command;
import dev.tehcn.pulse.event.KeyInputHandler;
import dev.tehcn.pulse.networking.ModMessages;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.command.CommandRegistryAccess;

public class PulseClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModMessages.registerS2CPackets();
        KeyInputHandler.register();

        ClientCommandRegistrationCallback.EVENT.register(PulseClient::registerCommands);
    }

    public static void registerCommands(CommandDispatcher<FabricClientCommandSource> dispatcher, CommandRegistryAccess registryAccess) {
        Help_Command.register(dispatcher);
    }
}
