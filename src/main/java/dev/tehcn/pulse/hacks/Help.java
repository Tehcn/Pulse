package dev.tehcn.pulse.hacks;

import dev.tehcn.pulse.utils.Chat;
import net.minecraft.text.Text;

public class Help {
    public static void run() {
        Chat.sendMessage(Text.translatable("pulse.commands.help").getString());
    }
}

