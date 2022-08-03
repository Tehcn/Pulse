package dev.tehcn.pulse.hacks;

import dev.tehcn.pulse.event.KeyInputHandler;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;

public class Keybind {
    static KeyBinding generate(String translationKey, int key) {
        return new KeyBinding(
                translationKey,
                InputUtil.Type.KEYSYM,
                key,
                KeyInputHandler.KEY_CATEGORY
        );
    }
}
