package dev.tehcn.pulse.hacks;

import dev.tehcn.pulse.Pulse;
import org.lwjgl.glfw.GLFW;

public class NoItemCooldown extends Hack {
    public NoItemCooldown() {
        this.name = "NoItemCooldown";
        this.hackEnabledTranslationKey = "message.pulse.noitemcooldown.enabled";
        this.hackDisabledTranslationKey = "message.pulse.noitemcooldown.disabled";
        this.keybind = Keybind.generate("key.pulse.toggle_noitemcooldown", GLFW.GLFW_KEY_N);
        Pulse.SETTINGS.put(this.name, false);
    }

    @Override
    public void run() {
        // doesn't even run here lmao
    }
}
