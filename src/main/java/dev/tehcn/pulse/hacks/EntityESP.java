package dev.tehcn.pulse.hacks;

import dev.tehcn.pulse.Pulse;
import org.lwjgl.glfw.GLFW;

public class EntityESP extends Hack {
    public EntityESP() {
        this.name = "EntityESP";
        this.hackEnabledTranslationKey = "message.pulse.entityesp.enabled";
        this.hackDisabledTranslationKey = "message.pulse.entityesp.disabled";
        this.keybind = Keybind.generate("key.pulse.toggle_entityesp", GLFW.GLFW_KEY_U);
        Pulse.SETTINGS.put(this.name, false);
    }

    @Override
    public void run() { /* Rendering Hacks do not use the run method */ }
}
