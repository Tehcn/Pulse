package dev.tehcn.pulse.event;

import dev.tehcn.pulse.Pulse;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;

public class KeyInputHandler {
    public static final String KEY_CATEGORY = "key.category.pulse.tutorial";

    public static KeyBinding toggleFullbrightKey;

    public static void registerKeyInputs() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            Pulse.INSTANCE.HACKS_MAP.forEach((name, hack) -> {
                if(hack.keybind.wasPressed()) Pulse.getHack(name).toggle();
            });
        });
    }

    public static void register() {
        Pulse.INSTANCE.HACKS_MAP.forEach((name, hack) -> KeyBindingHelper.registerKeyBinding(hack.keybind));
        registerKeyInputs();
    }
}
