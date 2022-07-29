package dev.tehcn.pulse.networking;

import dev.tehcn.pulse.Pulse;
import dev.tehcn.pulse.networking.packet.DrinkingC2SPacket;
import dev.tehcn.pulse.networking.packet.ExampleC2SPacket;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;

public class ModMessages {
    public static final Identifier DRINKING_ID = new Identifier(Pulse.MOD_ID, "drinking");
    public static final Identifier THIRST_SYNC_ID = new Identifier(Pulse.MOD_ID, "thirst_sync");
    public static final Identifier EXAMPLE_ID = new Identifier(Pulse.MOD_ID, "example");

    public static void registerC2SPackets() {
        ServerPlayNetworking.registerGlobalReceiver(EXAMPLE_ID, ExampleC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(DRINKING_ID, DrinkingC2SPacket::receive);
    }

    public static void registerS2CPackets() {

    }
}
