package dev.smerk3r.veynor.module;

import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.Identifier;

/** Simple HUD: FPS + coordinates. */
public class HudModule extends Module {
    public HudModule() {
        super("HUD (FPS / XYZ)", true);

        // NOTE: the draw-context class name has changed across 26.x snapshots.
        // `graphics` is the object passed by Fabric's HUD callback; adjust the type if needed.
        HudElementRegistry.addLast(Identifier.fromNamespaceAndPath("veynor", "hud"), (graphics, tickCounter) -> {
            if (!isEnabled()) return;
            Minecraft mc = Minecraft.getInstance();
            if (mc.player == null) return;

            String fps = mc.getFps() + " FPS";
            String xyz = String.format("XYZ %.1f %.1f %.1f", mc.player.getX(), mc.player.getY(), mc.player.getZ());

            graphics.drawString(mc.font, "Veynor Client", 6, 6, 0xFFB388FF, true);
            graphics.drawString(mc.font, fps, 6, 18, 0xFFFFFFFF, true);
            graphics.drawString(mc.font, xyz, 6, 30, 0xFFFFFFFF, true);
        });
    }
}
