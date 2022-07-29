package dev.tehcn.pulse.utils;

import dev.tehcn.pulse.Pulse;
import net.minecraft.text.Text;

public class Chat {
    public static void sendMessage(String message) {
        assert Pulse.MC.player != null;
        Pulse.MC.player.sendMessage(Text.of(message));
    }
}
