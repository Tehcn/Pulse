package dev.tehcn.pulse.mixin;

import dev.tehcn.pulse.Pulse;
import net.minecraft.network.listener.ServerPlayPacketListener;
import net.minecraft.network.packet.c2s.play.HandSwingC2SPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HandSwingC2SPacket.class)
public class HandSwingC2SPacketMixin {
    @Inject(at = @At("HEAD"), method = "apply(Lnet/minecraft/network/listener/ServerPlayPacketListener;)V")
    public void uh(ServerPlayPacketListener serverPlayPacketListener, CallbackInfo ci) {
        Pulse.LOGGER.info("swung hand");
    }
}
