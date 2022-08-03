package dev.tehcn.pulse.hacks;

import dev.tehcn.pulse.Pulse;
import dev.tehcn.pulse.event.listeners.LeftClickListener;
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
        Pulse.LOGGER.info("left clicked");
        jump();
    }

    private void jump()
    {
        Pulse.LOGGER.info("ran criticals");

        assert Pulse.MC.player != null;
        double posX = Pulse.MC.player.getX();
        double posY = Pulse.MC.player.getY();
        double posZ = Pulse.MC.player.getZ();

        sendPos(posX, posY + 0.0625D, posZ, true);
        sendPos(posX, posY, posZ, false);
        sendPos(posX, posY + 1.1E-5D, posZ, false);
        sendPos(posX, posY, posZ, false);
    }

    private void sendPos(double x, double y, double z, boolean onGround)
    {
        assert Pulse.MC.player != null;
        Pulse.MC.player.networkHandler.sendPacket(new PlayerMoveC2SPacket.PositionAndOnGround(x, y, z, onGround));
    }

    @Override
    public void run() {  }
}
