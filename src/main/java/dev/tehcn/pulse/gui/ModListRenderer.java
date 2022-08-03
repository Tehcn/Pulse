package dev.tehcn.pulse.gui;

import dev.tehcn.pulse.Pulse;
import dev.tehcn.pulse.hacks.Hack;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.ArrayList;

public class ModListRenderer {
    public static void render(ArrayList<Hack> hacks) {
        ArrayList<String> names = new ArrayList<>();
        for(Hack hack : hacks) names.add(hack.name);

        HudRenderCallback.EVENT.register((phase, listener) -> {
            TextRenderer fontRenderer = Pulse.MC.textRenderer;

            for(int i=0;i<names.toArray().length;i++) {
                String name = names.get(i);
                MutableText text = Text.literal(name).fillStyle(Style.EMPTY.withColor(Formatting.DARK_AQUA));
                fontRenderer.draw(
                        phase, text,
                        0f, Pulse.MC.getWindow().getHeight() + (i * 10f),
                        0x0077ff
                );
            }

        });
    }
}
