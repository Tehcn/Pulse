package dev.tehcn.pulse.hacks;

public class Hacks {
    public FullBright fullbright;
    public Speed speed;
    public NoItemCooldown noItemCooldown;
    public Criticals criticals;
    public KillAura killAura;

    public Hacks() {
        this.fullbright = new FullBright();
        this.speed = new Speed();
        this.noItemCooldown = new NoItemCooldown();
        this.criticals = new Criticals();
        this.killAura = new KillAura();
    }
}
