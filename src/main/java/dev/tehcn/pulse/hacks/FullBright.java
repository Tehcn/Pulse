package dev.tehcn.pulse.hacks;

import dev.tehcn.pulse.Pulse;
import dev.tehcn.pulse.event.KeyInputHandler;
import dev.tehcn.pulse.utils.Chat;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.lwjgl.glfw.GLFW;

public class FullBright extends Hack {
    public FullBright() {
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
