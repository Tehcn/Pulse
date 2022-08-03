package dev.tehcn.pulse.hacks;

import dev.tehcn.pulse.Pulse;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public abstract class Hack {
    public String name;
    public String hackEnabledTranslationKey;
    public String hackDisabledTranslationKey;
    public KeyBinding keybind;


    /**
     * Runs every tick
     */
    public abstract void run();
    public void toggle() {
        assert Pulse.MC.world != null;
        assert Pulse.MC.player != null;
        ClientPlayerEntity player = Pulse.MC.player;
        ClientWorld world = Pulse.MC.world;
        float pitch;
        String translationKey;

        if(Pulse.SETTINGS.get(this.name)) {
            // disabling
            pitch = 0.2f;
            translationKey = this.hackDisabledTranslationKey;
        } else {
            // enabling
            pitch = 0.9f;
            translationKey = this.hackEnabledTranslationKey;
        }

        Pulse.SETTINGS.replace(this.name, !Pulse.SETTINGS.get(this.name));

        // play ding sound
        world.playSound(null, player.getBlockPos(), SoundEvents.BLOCK_NOTE_BLOCK_CHIME, SoundCategory.PLAYERS,
                1f, pitch);
        // send message in actionbar
        player.sendMessage(Text.translatable(translationKey)
                .fillStyle(Style.EMPTY.withColor(Formatting.DARK_AQUA)), true);

        this.run();
    }
}
