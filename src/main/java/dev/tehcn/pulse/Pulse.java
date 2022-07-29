package dev.tehcn.pulse;

import dev.tehcn.pulse.networking.ModMessages;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class Pulse implements ModInitializer {
	public static final String MOD_ID = "pulse";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final MinecraftClient MC = MinecraftClient.getInstance();
	public static final HashMap<String, Boolean> SETTINGS = new HashMap<>();
	private Path pulseFolder;

	@Override
	public void onInitialize() {
		LOGGER.info("Registering packets");
		ModMessages.registerC2SPackets();

		LOGGER.info("Creating folder .minecraft/pulse");
		this.pulseFolder = createPulseFolder();

		LOGGER.info("Loading settings");
	}

	private Path createPulseFolder() {
		Path dotMinecraft = MC.runDirectory.toPath().normalize();
		Path pulseFolder = dotMinecraft.resolve("pulse");

		try {
			Files.createDirectories(pulseFolder);
		} catch(IOException e) {
			throw new RuntimeException("Couldn't create .minecraft/pulse folder.", e);
		}

		return pulseFolder;
	}

	public Path getPulseFolder() {
		return this.pulseFolder;
	}
}
