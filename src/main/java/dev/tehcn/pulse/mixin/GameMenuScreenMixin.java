package dev.tehcn.pulse.mixin;

import dev.tehcn.pulse.screens.PulseScreen;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameMenuScreen.class)
public abstract class GameMenuScreenMixin extends Screen {
    protected GameMenuScreenMixin(Text text) { super(text); }

    @Inject(at = @At("HEAD"), method = "initWidgets()V")
    private void initWidgets(CallbackInfo ci) {
        this.addDrawableChild(new ButtonWidget(10, 20, 90, 20, Text.literal("Pulse"), (button) -> {
            if (this.client != null) {
                this.client.setScreen(new PulseScreen(this));
            }
        }));
    }
}

