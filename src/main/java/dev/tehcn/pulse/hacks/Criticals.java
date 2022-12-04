package dev.tehcn.pulse.hacks;

import dev.tehcn.pulse.Pulse;
import dev.tehcn.pulse.event.listeners.LeftClickListener;
import dev.tehcn.pulse.utils.Chat;
import net.minecraft.entity.LivingEntity;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import org.lwjgl.glfw.GLFW;

public class Criticals extends Hack implements LeftClickListener {

    public Criticals() {
        this.name = "Criticals";
        this.hackEnabledTranslationKey = "message.pulse.criticals.enabled";
        this.hackDisabledTranslationKey = "message.pulse.criticals.disabled";
        this.keybind = Keybind.generate("key.pulse.toggle_criticals", GLFW.GLFW_KEY_K);
        Pulse.SETTINGS.put(this.name, false);
    }

    @Override
    public void onLeftClick(LeftClickEvent event) {
        Chat.sendMessage("left clicked");
        jump();
    }

    private void jump()
    {
        Chat.sendMessage("ran criticals");

        assert Pulse.MC.player != null;

        Pulse.MC.player.addVelocity(0, 0.1, 0);
        Pulse.MC.player.fallDistance = 0.1F;
        Pulse.MC.player.setOnGround(false);
    }

    @Override
    public void run() {  }
}
