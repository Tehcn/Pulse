package dev.tehcn.pulse.hacks;

import java.util.ArrayList;
import java.util.Iterator;

public class Hacks implements Iterable<Hack> {
    public Fullbright fullbright;
    public Speed speed;
    public NoItemCooldown noItemCooldown;
    public Criticals criticals;
    public KillAura killAura;
    public EntityESP entityESP;

    public Reach reach;

    public Hacks() {
        this.fullbright = new Fullbright();
        this.speed = new Speed();
        this.noItemCooldown = new NoItemCooldown();
        this.criticals = new Criticals();
        this.killAura = new KillAura();
        this.entityESP = new EntityESP();
        this.reach = new Reach();
    }

    public Iterator<Hack> iterator() {
        return new HacksIterator(this);
    }

    public class HacksIterator implements Iterator<Hack> {

        private ArrayList<Hack> hacks;
        private Iterator<Hack> iterator;

        public HacksIterator(Hacks hs) {
            this.hacks = new ArrayList<>();
            this.hacks.add(hs.fullbright);
            this.hacks.add(hs.speed);
            this.hacks.add(hs.noItemCooldown);
            this.hacks.add(hs.criticals);
            this.hacks.add(hs.killAura);
            this.hacks.add(hs.entityESP);
            this.hacks.add(hs.reach);
            this.iterator = hacks.iterator();
        }

        @Override
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override
        public Hack next() {
            return this.iterator.next();
        }
    }

}

