package dev.tehcn.pulse.hacks;

import dev.tehcn.pulse.Pulse;
import org.lwjgl.glfw.GLFW;

public class Reach extends Hack {
    public Reach() {
        this.name = "Reach";
        this.hackEnabledTranslationKey = "message.pulse.reach.enabled";
        this.hackDisabledTranslationKey = "message.pulse.reach.disabled";
        this.keybind = Keybind.generate("key.pulse.toggle_reach", GLFW.GLFW_KEY_T);
        Pulse.SETTINGS.put(this.name, false);
    }

    @Override
    public void run() {

    }
}
