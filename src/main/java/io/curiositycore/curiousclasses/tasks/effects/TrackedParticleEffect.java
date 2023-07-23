package io.curiositycore.curiousclasses.tasks.effects;

import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * This is an effect that will track a target and follow it as long as the effect is running.
 */
public class TrackedParticleEffect extends BukkitRunnable {
    /**
     * The entity that the effect is tracking.
     */
    private Entity targetOfEffect;

    /**
     * The particle that the effect generates.
     */
    private Particle particleEffect;

    /**
     * The number of particles that the effect generates per tick.
     */
    private int numberOfParticles;
    public TrackedParticleEffect(Particle particleEffect, Entity targetOfEffect, int numberOfParticles){
        this.targetOfEffect = targetOfEffect;
        this.particleEffect = particleEffect;
        this.numberOfParticles = numberOfParticles;
    }
    @Override
    public void run() {
        this.targetOfEffect.getWorld().spawnParticle(particleEffect,this.targetOfEffect.getLocation(),numberOfParticles);
    }
}
