package dev.smerk3r.veynor.gui;

import dev.smerk3r.veynor.module.Module;
import dev.smerk3r.veynor.module.ModuleManager;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

/** Settings menu: one toggle button per module. */
public class VeynorScreen extends Screen {
    private final ModuleManager manager;

    public VeynorScreen(ModuleManager manager) {
        super(Component.literal("Veynor Client"));
        this.manager = manager;
    }

    @Override
    protected void init() {
        int y = 40;
        for (Module m : manager.getModules()) {
            addRenderableWidget(Button.builder(label(m), b -> {
                m.toggle();
                b.setMessage(label(m));
            }).bounds(width / 2 - 100, y, 200, 20).build());
            y += 24;
        }
    }

    private Component label(Module m) {
        return Component.literal(m.getName() + ": " + (m.isEnabled() ? "ON" : "OFF"));
    }
}
