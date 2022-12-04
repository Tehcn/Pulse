package dev.tehcn.pulse.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dev.tehcn.pulse.Pulse;
import net.minecraft.text.Text;

import java.io.FileWriter;
import java.io.IOException;

public class ConfigFile {
    public static JsonObject encode(String data) {
        return JsonParser.parseString(data).getAsJsonObject();
    }

    public static void writeToFile(JsonObject json) {
        try(FileWriter writer = new FileWriter(Pulse.INSTANCE.getPulseFolder().getFileName().toString())) {
            writer.write(json.toString());
        } catch(IOException e) {
            e.printStackTrace();
            Chat.sendMessage(Text.literal("Unable to save config to .minecraft/pulse/config.json"));
        }
    }

    public static String decode(JsonObject json) {
        return json.toString();
    }
}
