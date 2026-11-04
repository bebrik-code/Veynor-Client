package dev.smerk3r.veynor;

import dev.smerk3r.veynor.cosmetics.CosmeticManager;
import dev.smerk3r.veynor.module.ModuleManager;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VeynorClient implements ClientModInitializer {
    public static final String NAME = "Veynor Client";
    public static final String OWNER = "smerk3r";
    public static final Logger LOG = LoggerFactory.getLogger("veynor");

    public static ModuleManager modules;
    public static CosmeticManager cosmetics;

    @Override
    public void onInitializeClient() {
        modules = new ModuleManager();
        cosmetics = new CosmeticManager();
        modules.init();
        LOG.info("{} by {} loaded", NAME, OWNER);
    }
}
