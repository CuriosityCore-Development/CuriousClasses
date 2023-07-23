package io.curiositycore.curiousclasses.archetypes.progression;

import io.curiositycore.curiousclasses.tasks.effects.TrackedParticleEffect;
import io.curiositycore.curiousclasses.utils.OwnsTrackedEffect;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;
import java.util.UUID;

/**
 * <p>Abstract that represents the generalisation of any ArchetypeExperience Orb within the plugin. These custom experience
 * orbs provide no vanilla MC experience, but rather progression towards leveling up the Archetype to the next tier.</p>
 *
 * These custom experience orbs will have a special effect that is present with the orb, to distinguish them from normal
 * experience orbs. E.g: A water based archetype may have water particle effects following the orb.
 */
public abstract class ArchetypeExperience implements OwnsTrackedEffect {
    /**
     * Particle utilised for the tracked effect.
     */
    protected Particle particleForXp;

    /**
     * Number of particles to generate during the effect.
     */
    protected int numberOfParticles;

    /**
     * Amount of progress towards an Archetype upgrade that this experience will provide.
     */
    @Getter
    protected int progressAmount;

    /**
     * The experience orb entity that is generated for this Archetype Experience.
     */
    @Getter
    protected ExperienceOrb experienceOrb;

    /**
     * The unique id of the target of this Archetype Experience. Only this target can pickup the experience.
     */
    @Getter
    protected UUID targetid;

    /**
     * The particle effect task that initiates on spawning of the Archetype Experience's orb entity.
     */
    protected TrackedParticleEffect particleEffect;

    /**
     * Constructor which initialises the various components of the particle effect task.
     */
    protected ArchetypeExperience(){
        this.particleForXp = setParticle();
        this.numberOfParticles = setNumberOfParticles();
        this.progressAmount = setProgressValue();
    }

    /**
     * Spawns an experience orb with 0 vanilla minecraft experience. Used as the storage of the Archetype Experience
     * data.
     * @param playerToSpawnFor The player who triggered the spawning of the experience.
     * @param locationToSpawnExpOrb The location to spawn the experience orb.
     */
    public void spawnExperienceOrb(Player playerToSpawnFor, Location locationToSpawnExpOrb){
       this.experienceOrb= (ExperienceOrb) playerToSpawnFor.getWorld().spawnEntity(locationToSpawnExpOrb, EntityType.EXPERIENCE_ORB);
       this.experienceOrb.setExperience(0);
       this.particleEffect = new TrackedParticleEffect(particleForXp,this.experienceOrb,numberOfParticles);
       initEffect();

    }

    /**
     * The experience orb entity's unique id.
     * @return The unique id of the experience orb.
     */
    public UUID getExperienceOrbId(){
        return this.experienceOrb.getUniqueId();
    }

    /**
     * Set the particle to spawn as part of the Archetype Experience's particle effect.
     * @return The particle spawned for the Experience effect.
     */
    protected abstract Particle setParticle();

    /**
     * Set the number of particles to spawn for the Archetype Experience's particle effect.
     * @return The number of particles spawned for the Experience effect.
     */
    protected abstract int setNumberOfParticles();

    /**
     * Set the amount of progress this Archetype Experience provides the target.
     * @return The amount of stored progress in this Experience Orb.
     */
    protected abstract int setProgressValue();

    @Override
    public void initEffect() {
        this.particleEffect.runTaskTimer(Objects.requireNonNull(Bukkit.getPluginManager().getPlugin("CuriousClasses")),0,5);
    }

    @Override
    public void endEffect() {
        this.particleEffect.cancel();
    }
}
