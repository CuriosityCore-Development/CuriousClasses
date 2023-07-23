package io.curiositycore.curiousclasses.archetypes.progression;

import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public abstract class ArchetypeExperience {
    protected Particle particleForXp;
    protected int numberOfParticles;
    protected ExperienceOrb experienceOrb;
    @Getter
    protected UUID targetid;
    protected Particle.DustOptions particleOptions;

    public void spawnExperienceOrb(Player playerToSpawnFor, Location locationToSpawnExpOrb){
       this.experienceOrb= (ExperienceOrb) playerToSpawnFor.getWorld().spawnEntity(locationToSpawnExpOrb, EntityType.EXPERIENCE_ORB);
       this.experienceOrb.setExperience(0);

    }
    public void spawnParticle(Location locationToSpawnParticles, Player playerToSpawnFor){
        playerToSpawnFor.spawnParticle(this.particleForXp,locationToSpawnParticles,numberOfParticles);
    }
    public UUID getExperienceOrbId(){
        return this.experienceOrb.getUniqueId();
    }
    protected abstract Particle setParticle();
    protected abstract int setNumberOfParticles();
    protected abstract int setXpValue();
    protected abstract int setArchetypeExperienceValue();

}
