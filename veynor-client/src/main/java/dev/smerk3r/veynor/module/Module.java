package dev.smerk3r.veynor.module;

public abstract class Module {
    private final String name;
    private boolean enabled;

    protected Module(String name, boolean enabledByDefault) {
        this.name = name;
        this.enabled = enabledByDefault;
    }

    public String getName() { return name; }
    public boolean isEnabled() { return enabled; }
    public void toggle() { enabled = !enabled; }
    public void setEnabled(boolean v) { enabled = v; }
}
