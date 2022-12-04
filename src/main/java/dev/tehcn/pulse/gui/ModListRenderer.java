package dev.tehcn.pulse.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.tehcn.pulse.Pulse;
import dev.tehcn.pulse.hacks.Hack;
import dev.tehcn.pulse.utils.Colors;
import dev.tehcn.pulse.utils.Renderer;
import net.fabricmc.fabric.api.renderer.v1.RendererAccess;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

import java.util.ArrayList;

public class ModListRenderer {

    public static void render(MatrixStack matrices, float deltaTick) {

        TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;

        float i = 0;
        for(Hack hack : Pulse.INSTANCE.hacks) {
            if(Pulse.SETTINGS.get(hack.name)) {
                String name = hack.name;
                MutableText text = Text.literal(name);
                textRenderer.drawWithShadow(
                        matrices, text,
                        10f, 10f + (i * 10f),
                        0x0077ff
                );
                i += 1f;
            }
        }

        Renderer.drawSquare(0, 0, 100, 15 + (((int) i) * 10), new Colors.ColorRGBA(0, 0, 0, 100));
    }
}
