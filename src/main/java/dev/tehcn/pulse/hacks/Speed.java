package dev.tehcn.pulse.hacks;

import dev.tehcn.pulse.Pulse;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.glfw.GLFW;

public class Speed extends Hack {
    public Speed() {
        this.name = "Speed";
        this.hackEnabledTranslationKey = "message.pulse.speed.enabled";
        this.hackDisabledTranslationKey = "message.pulse.speed.disabled";
        this.keybind = Keybind.generate("key.pulse.toggle_speed", GLFW.GLFW_KEY_B);
        Pulse.SETTINGS.put(this.name, false);
    }

    @Override
    public void run() {
        ClientPlayerEntity player = Pulse.MC.player;
        Vec3d vel = player.getVelocity();

        if(player.forwardSpeed > 0 && !player.horizontalCollision) player.setSprinting(true);

        Vec3d oldVel = vel;

        // hopefully this makes it not slippery
        Vec3d look = player.getRotationVec(1);
        vel = vel.multiply(vel.dotProduct(look) * 100);

        // don't change the y velocity!
        vel = new Vec3d(vel.x, oldVel.y, vel.z);

        player.setVelocity(vel.x * 1.8, vel.y, vel.z * 1.8);

        if(!player.input.pressingForward && !player.input.pressingBack && !player.input.pressingLeft && !player.input.pressingRight)
            player.setVelocity(0, vel.y, 0);

        vel = player.getVelocity();

        double playerSpeed = Math.sqrt(Math.pow(vel.x, 2) + Math.pow(vel.z, 2));

        double maxSpeed = 0.66f;

        if(playerSpeed > maxSpeed)
            player.setVelocity(
                    vel.x / playerSpeed * maxSpeed,
                    vel.y,
                    vel.z / playerSpeed * maxSpeed
            );
    }
}
