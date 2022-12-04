package dev.tehcn.pulse.hacks;

import dev.tehcn.pulse.Pulse;
import dev.tehcn.pulse.utils.Chat;
import org.lwjgl.glfw.GLFW;

public class Fullbright extends Hack {
    public Fullbright() {
        this.name = "Fullbright";
        this.hackEnabledTranslationKey = "message.pulse.fullbright.enabled";
        this.hackDisabledTranslationKey = "message.pulse.fullbright.disabled";
        this.keybind = Keybind.generate("key.pulse.toggle_fullbright", GLFW.GLFW_KEY_B);
        Pulse.SETTINGS.put(this.name, false);
    }

    @Override
    public void run() {
        Chat.sendMessage("Fullbright is broken :(");
/*
        if(Pulse.SETTINGS.get(this.name)) Pulse.MC.options.getGamma().setValue(100D);
        else Pulse.MC.options.getGamma().setValue(0D);
*/
    }
}
