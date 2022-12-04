package dev.tehcn.pulse;

import dev.tehcn.pulse.event.EventManager;
import dev.tehcn.pulse.event.listeners.LeftClickListener;
import dev.tehcn.pulse.gui.ModListRenderer;
import dev.tehcn.pulse.hacks.*;
import dev.tehcn.pulse.networking.ModMessages;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.server.network.ServerPlayerEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class Pulse implements ModInitializer {
	public static Pulse INSTANCE = null;
	public static final String MOD_ID = "pulse";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final MinecraftClient MC = MinecraftClient.getInstance();
	public static final HashMap<String, Boolean> SETTINGS = new HashMap<>();
	public final HashMap<String, Hack> HACKS_MAP = new HashMap<>();
	public Hacks hacks;
	private Path pulseFolder;
	public HashMap<String, ServerPlayerEntity> players;
	public EventManager eventManager;

	@Override
	public void onInitialize() {
		if(INSTANCE != null) {
			throw new ExceptionInInitializerError();
		}

		LOGGER.info("Setting instance");
		INSTANCE = this;

		LOGGER.info("Registering packets");
		ModMessages.registerC2SPackets();

		LOGGER.info("Creating folder .minecraft/pulse");
		this.pulseFolder = createPulseFolder();

		LOGGER.info("Loading hacks");
		loadHacks();

		LOGGER.info("Registering Renderers");
//		ModListRenderer.render(new ArrayList<>(Pulse.INSTANCE.HACKS_MAP.values()));

		LOGGER.info("Will record encountered players");
		this.players = new HashMap<>();

		LOGGER.info("Initializing event manager");
		this.eventManager = new EventManager();
		initializeEventListeners();
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

	private void loadHacks() {
		this.hacks = new Hacks();
		this.HACKS_MAP.put("Fullbright", this.hacks.fullbright);
		this.HACKS_MAP.put("NoItemCooldown", this.hacks.noItemCooldown);
		this.HACKS_MAP.put("Speed", this.hacks.speed);
		this.HACKS_MAP.put("Criticals", this.hacks.criticals);
		this.HACKS_MAP.put("KillAura", this.hacks.killAura);
		this.HACKS_MAP.put("EntityESP", this.hacks.entityESP);
	}

	private void initializeEventListeners() {
		// criticals
		this.eventManager.add(LeftClickListener.class, this.hacks.criticals);
	}

	public Path getPulseFolder() {
		return this.pulseFolder;
	}

	public static Hack getHack(String name) {
		return Pulse.INSTANCE.HACKS_MAP.get(name);
	}
}
