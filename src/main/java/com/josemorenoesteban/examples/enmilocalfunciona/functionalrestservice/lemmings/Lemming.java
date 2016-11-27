package com.josemorenoesteban.examples.enmilocalfunciona.functionalrestservice.lemmings;

import static java.util.Arrays.asList;
import static java.util.Optional.ofNullable;

import java.util.List;
import java.util.Optional;

public class Lemming {
    private final String  name;
    private final boolean permanentSkill;
    private final String  description;
    
    private Lemming(final String name, final boolean permanentSkill, final String description) {
        this.name           = name;
        this.permanentSkill = permanentSkill;
        this.description    = description;
    }
    
    public String  name()                 { return this.name; }
    public boolean isPermanentSkill()     { return this.permanentSkill; }
    public Optional<String> description() { return ofNullable(this.description); }
    
    public static Lemming climber() {
        return new Lemming("climber", true, 
                           "Climbers can scale vertical walls no matter how high, but will fall back down if they hit a ceiling.");
    }

    public static Lemming floater() {
        return new Lemming("floater", true, 
                           "A floater has the capability to survive a fall of any height by using an umbrella.");
    }

    public static Lemming bomber() {
        return new Lemming("bomber", true, 
                           "A bomber lights the fuse of a bomb and holds it until it detonates, creating a knockback explosion. " + 
                           "The explosion sends nearby lemmings flying and stuns them temporarily, and also leaves a hole in the " +
                           "ground (unless it is steel).");
    }

    public static Lemming blocker() {
        return new Lemming("blocker", false, 
                           "A blocker stands still, and any lemmings coming in contact with him, including Walkers, Builders " +
                           "or Miners, will turn around and start going in the opposite direction. A blocker can become a " +
                           "normal Lemming if the ground beneath him is removed. More often, they are removed using an exploder, " + 
                           "or nuked at the end of the level.");
    }
    
    public static Lemming builder() {
        return new Lemming("builder", false, 
                           "Builders create a diagonal staircase upwards, consisting of twelve bricks. Once a Builder runs out " +
                           "of bricks, he will shrug his shoulders and continue walking. You can make him build again by selecting " + 
                           "him before he walks off the bridge. The lemming will stop and turn back if it bumps into a wall or ceiling.");
    }

    public static Lemming basher() {
        return new Lemming("basher", false, 
                           "A basher digs a horizontal tunnel through any surface, as long as it isn't steel.");
    }

    public static Lemming miner() {
        return new Lemming("miner", false, 
                           "A miner digs a diagonal tunnel downwards. He will stop if he hits steel, if he runs out of ground, " + 
                           "or if he is told to do something else.");
    }

    public static Lemming digger() {
        return new Lemming("digger", false, 
                           "Diggers create a vertical tunnel downwards, not stopping until they run out of room to dig or " + 
                           "until they hit steel. You can also stop a digger by giving him another task, such as a builder.");
    }

    public static List<Lemming> lemmings() {
        return asList( climber(), floater(), bomber(), blocker(), builder(), basher(), miner(), digger() );
    }
}
