package dev.smerk3r.veynor.cosmetics;

public record Cosmetic(String id, String displayName, Slot slot, String texturePath) {
    public enum Slot { CAPE, HAT, WINGS, AURA }
}
