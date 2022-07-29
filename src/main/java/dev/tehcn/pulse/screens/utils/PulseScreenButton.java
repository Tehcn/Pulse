package dev.tehcn.pulse.screens.utils;

import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class PulseScreenButton extends ButtonWidget {
    public PulseScreenButton(int x, int y, int width, int height, Text message, ButtonWidget.PressAction onPress) {
        super(x, y, width, height, message, onPress);
    }
}
