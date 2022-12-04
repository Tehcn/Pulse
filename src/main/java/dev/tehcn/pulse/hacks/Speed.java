package dev.tehcn.pulse.hacks;

import dev.tehcn.pulse.Pulse;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.Quaternion;
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
        if(!player.input.pressingForward && !player.input.pressingBack && !player.input.pressingLeft && !player.input.pressingRight) {
            player.setVelocity(0, player.getVelocity().getY(), 0);
            return;
        }

        if(player.forwardSpeed > 0 && !player.horizontalCollision) player.setSprinting(true);


        Vec3d velocity = player.getVelocity();
        double speedMultiplier = 1.8;
        Vec3d newVelocity = velocity.multiply(speedMultiplier, 1, speedMultiplier);

        // Check if the new velocity vector is greater than 10 blocks per second
        if (newVelocity.length() > 10) {
            // Scale the new velocity vector down to 10 blocks per second
            newVelocity = newVelocity.multiply(0.01 / newVelocity.length());
        }

        // Update the player's velocity with the new velocity vector
        player.setVelocity(newVelocity);

    }
}
