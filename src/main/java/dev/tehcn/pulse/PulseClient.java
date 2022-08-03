package dev.tehcn.pulse;

import dev.tehcn.pulse.event.KeyInputHandler;
import dev.tehcn.pulse.networking.ModMessages;
import net.fabricmc.api.ClientModInitializer;

public class PulseClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModMessages.registerS2CPackets();
        KeyInputHandler.register();
    }

}
