package dev.tehcn.pulse.hacks;

import dev.tehcn.pulse.Pulse;
import dev.tehcn.pulse.utils.Chat;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;
import java.util.List;

public class KillAura extends Hack {
    public KillAura() {
        this.name = "KillAura";
        this.hackEnabledTranslationKey = "message.pulse.killaura.enabled";
        this.hackDisabledTranslationKey = "message.pulse.killaura.disabled";
        this.keybind = Keybind.generate("key.pulse.toggle_killaura", GLFW.GLFW_KEY_Z);
        Pulse.SETTINGS.put(this.name, false);
    }

    @Override
    public void run() {
        assert Pulse.MC.player != null;
        AbstractClientPlayerEntity victim = getNearestPlayer();
        Pulse.MC.player.attack(victim);

    }

    private AbstractClientPlayerEntity getNearestPlayer() {
        assert Pulse.MC.player != null;
        assert Pulse.MC.world != null;
        Vec3d player = Pulse.MC.player.getPos();
        List<AbstractClientPlayerEntity> players = Pulse.MC.world.getPlayers();

        AbstractClientPlayerEntity nearestPlayer = null;

        for(AbstractClientPlayerEntity currentPlayer : players) {
            if(nearestPlayer == null) nearestPlayer = currentPlayer;
            if(player.distanceTo(currentPlayer.getPos()) > player.distanceTo(nearestPlayer.getPos())) nearestPlayer = currentPlayer;
        }

        if (nearestPlayer == null) {
            Chat.sendMessage(Text.translatable("message.pulse.killaura.noplayers")
                    .fillStyle(Style.EMPTY.withColor(Formatting.YELLOW)));
        } else {
            Chat.sendMessage(Text.of("Targeting " + nearestPlayer.getDisplayName().getString()).copy()
                    .fillStyle(Style.EMPTY.withColor(Formatting.YELLOW)));
        }

        return nearestPlayer;
    }
}
