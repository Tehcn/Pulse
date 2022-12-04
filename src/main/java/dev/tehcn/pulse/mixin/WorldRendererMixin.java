package dev.tehcn.pulse.mixin;

import dev.tehcn.pulse.Pulse;
import dev.tehcn.pulse.utils.Colors;
import dev.tehcn.pulse.utils.Renderer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldRenderer.class)
public class WorldRendererMixin {
    @Inject(at = @At("RETURN"), method = "render")
    public void render(MatrixStack matrices, float tickDelta, long limitTime, boolean renderBlockOutline, Camera camera, GameRenderer gameRenderer, LightmapTextureManager lightmapTextureManager, Matrix4f positionMatrix, CallbackInfo ci) {
        if(Pulse.SETTINGS.get("EntityESP")) {
            if(Pulse.MC.world != null) {
                Iterable<Entity> entities = Pulse.MC.world.getEntities();
                for(Entity entity : entities) {
                    Box box = entity.getBoundingBox();
                    Renderer.drawBox(matrices, camera, box, new Colors.ColorRGBA(255, 255, 255, 100), false);
                }
            }
        }
    }
}
