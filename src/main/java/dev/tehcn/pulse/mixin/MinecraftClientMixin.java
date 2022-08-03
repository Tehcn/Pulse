package dev.tehcn.pulse.mixin;

import dev.tehcn.pulse.Pulse;
import dev.tehcn.pulse.gui.ModListRenderer;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.HashMap;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
    @Shadow private int itemUseCooldown;

    @Inject(at = @At("HEAD"), method = "tick()V")
    public void tick(CallbackInfo ci) {

        if(Pulse.MC.player != null) {
            Pulse.INSTANCE.players = new HashMap<>();

            if(Pulse.SETTINGS.get("NoItemCooldown")) this.itemUseCooldown = 0;
            if(Pulse.SETTINGS.get("Speed")) Pulse.INSTANCE.hacks.speed.run();

        }

    }
}
