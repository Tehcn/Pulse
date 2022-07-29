package dev.tehcn.pulse.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;

public class DrinkingC2SPacket implements IPacket {
    private static final String MESSAGE_DRINKING_WATER = "message.pulse.drank_water";
    private static final String MESSAGE_NO_WATER_NEARBY = "message.pulse.no_water";

    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        // server-side only
        ServerWorld world = player.getWorld();
        if(isWaterAroundThem(player, world)) {
            // notify the player
            player.sendMessage(Text.translatable(MESSAGE_DRINKING_WATER)
                    .fillStyle(Style.EMPTY.withColor(Formatting.DARK_AQUA)), true);
            // play drinking sound
            world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_GENERIC_DRINK, SoundCategory.PLAYERS,
                    0.5f, world.random.nextFloat() * 0.1f + 0.9f);
            // change water level
        } else {
            // notify the player
            player.sendMessage(Text.translatable(MESSAGE_NO_WATER_NEARBY)
                    .fillStyle(Style.EMPTY.withColor(Formatting.RED)), true);
        }
    }

    private static boolean isWaterAroundThem(ServerPlayerEntity player, ServerWorld world) {
        return BlockPos.stream(player.getBoundingBox().expand(2, 1, 2))
                .map(world::getBlockState).filter(state -> state.isOf(Blocks.WATER)).toArray().length > 0;
    }
}
