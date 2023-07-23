package io.curiositycore.curiousclasses.archetypes.progression.types;

import io.curiositycore.curiousclasses.archetypes.progression.ArchetypeExperience;
import org.bukkit.Particle;

/**
 * Proof of concept class to see if experience works, is linked to the warrior class.
 */
public class WarriorExperienceOrb extends ArchetypeExperience {
    @Override
    protected Particle setParticle() {
        return Particle.REDSTONE;
    }

    @Override
    protected int setNumberOfParticles() {
        return 2;
    }

    @Override
    protected int setProgressValue() {
        return 5;
    }
}
