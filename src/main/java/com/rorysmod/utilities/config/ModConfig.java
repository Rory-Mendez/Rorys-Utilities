package com.rorysmod.utilities.config;

import forge.Configuration;
import forge.Property;
import org.lwjgl.input.Keyboard;

import java.io.File;

/**
 * Loads and exposes all mod configuration values.
 *
 * Uses forge.Configuration (package: forge, NOT net.minecraftforge.common).
 * Confirmed present in Forge 3.4.9.171 client jar.
 *
 * API: getOrCreateBooleanProperty(String name, String category, boolean default)
 *      getOrCreateIntProperty(String name, String category, int default)
 * Both return forge.Property with .getBoolean(boolean) / .getInt(int) methods.
 */
public class ModConfig {

    private final Configuration forge;

    private boolean ctrlSprintEnabled;
    private int     sprintKeyCode;

    public ModConfig(File file) {
        this.forge = new Configuration(file);
    }

    public void load() {
        forge.load();

        Property enableProp = forge.getOrCreateBooleanProperty(
                "enableCtrlSprint",
                Configuration.CATEGORY_GENERAL,
                true
        );
        enableProp.comment = "Enable Ctrl Sprint (hold sprint key while moving forward to sprint).";
        ctrlSprintEnabled  = enableProp.getBoolean(true);

        Property keyProp = forge.getOrCreateIntProperty(
                "sprintKey",
                Configuration.CATEGORY_GENERAL,
                Keyboard.KEY_LCONTROL
        );
        keyProp.comment = "LWJGL key code for the sprint key. Default: "
                + Keyboard.KEY_LCONTROL + " (Left Control).";
        sprintKeyCode = keyProp.getInt(Keyboard.KEY_LCONTROL);

        forge.save();
    }

    public boolean isCtrlSprintEnabled() {
        return ctrlSprintEnabled;
    }

    public int getSprintKeyCode() {
        return sprintKeyCode;
    }
}
