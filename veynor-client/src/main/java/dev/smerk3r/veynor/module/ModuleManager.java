package dev.smerk3r.veynor.module;

import dev.smerk3r.veynor.gui.VeynorScreen;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    private final List<Module> modules = new ArrayList<>();
    private KeyMapping openMenuKey;

    public void init() {
        modules.add(new HudModule());

        // NOTE: KeyMapping constructor / category type changed between versions.
        // If this line fails to compile on 26.3, check the Fabric docs for the current signature.
        openMenuKey = KeyMappingHelper.registerKeyMapping(new KeyMapping(
                "key.veynor.menu", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_RIGHT_SHIFT,
                KeyMapping.Category.MISC));

        ClientTickEvents.END_CLIENT_TICK.register(mc -> {
            while (openMenuKey.consumeClick()) {
                mc.setScreen(new VeynorScreen(this));
            }
        });
    }

    public List<Module> getModules() { return modules; }
}
