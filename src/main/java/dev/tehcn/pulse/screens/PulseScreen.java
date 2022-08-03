package dev.tehcn.pulse.screens;

import dev.tehcn.pulse.Pulse;
import dev.tehcn.pulse.screens.utils.PulseScreenButton;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;

public class PulseScreen extends Screen {

    private final Screen parent;

    public PulseScreen(Screen parent) {
        super(Text.literal("Pulse"));
        this.parent = parent;
    }

    Text flyText() {
        boolean fullbrightEnabled = Pulse.SETTINGS.get("fullbright");
        return Text.literal("Fullbright " + (fullbrightEnabled ? "Enabled" : "Disabled"));
    }

    @Override
    protected void init() {
        // Fly button
        this.addDrawableChild(new PulseScreenButton(
            this.width / 2 - 50, this.height / 2 - 80,
            100, 20,
            flyText(), (button) -> {
                    button.setMessage(flyText());
                    Pulse.INSTANCE.hacks.fullbright.toggle();
                }
            )
        );
        // Back button
        this.addDrawableChild(new PulseScreenButton(
            this.width / 2 - (150 / 2), this.height / 2 + 120,
            150, 20,
            ScreenTexts.BACK, (button) -> {
                assert this.client != null;
                    this.client.setScreen(this.parent);
                }
            )
        );
    }
}
