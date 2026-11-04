package dev.smerk3r.veynor.cosmetics;

import java.util.*;

/**
 * Local cosmetics state. Step 1: you equip items and see them on yourself.
 * Step 2 (later): a small backend stores "player UUID -> equipped cosmetic ids",
 * the client fetches it for nearby players and renders the same items on them.
 * Rendering itself is added as a render-layer on the player model.
 */
public class CosmeticManager {
    private final Map<String, Cosmetic> catalog = new LinkedHashMap<>();
    private final Map<Cosmetic.Slot, Cosmetic> equipped = new EnumMap<>(Cosmetic.Slot.class);

    public CosmeticManager() {
        register(new Cosmetic("veynor_cape", "Veynor Cape", Cosmetic.Slot.CAPE, "textures/cosmetics/veynor_cape.png"));
        register(new Cosmetic("halo", "Halo", Cosmetic.Slot.HAT, "textures/cosmetics/halo.png"));
    }

    public void register(Cosmetic c) { catalog.put(c.id(), c); }
    public Collection<Cosmetic> all() { return catalog.values(); }
    public void equip(Cosmetic c) { equipped.put(c.slot(), c); }
    public void unequip(Cosmetic.Slot s) { equipped.remove(s); }
    public Optional<Cosmetic> get(Cosmetic.Slot s) { return Optional.ofNullable(equipped.get(s)); }
}
