package io.curiositycore.curiousclasses.archetypes.progression;

import io.curiositycore.curiousclasses.archetypes.managers.ArchetypeManager;
import io.curiositycore.curiousclasses.archetypes.managers.CustomExperienceManager;

import com.destroystokyo.paper.event.player.PlayerPickupExperienceEvent;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;

import java.net.http.WebSocket;
import java.util.UUID;

/**
 * Listener for events that could potentially be progression events within the plugin. This includes events that
 * could involve {@linkplain io.curiositycore.curiousclasses.archetypes.progression.ArchetypeExperience ArchetypeExperience}
 * drops.
 */
public class ProgressionListener implements Listener {
    /**
     * Instance of the CustomExperienceManager of the plugin.
     */
    CustomExperienceManager customExperienceManager;
    ArchetypeManager archetypeManager;

    /**
     * Constructor which initialises the custom experience manager.
     * @param customExperienceManager The plugin's custom experience manager.
     */
    public ProgressionListener(ArchetypeManager archetypeManager, CustomExperienceManager customExperienceManager){
        this.customExperienceManager = customExperienceManager;
        this.archetypeManager = archetypeManager;
    }

    /**
     * Ensures that, if an entity is targeting a player, and that entity is a custom experience orb, that it only
     * targets the player it is linked to. This prevents accidental pick-up of the exp.
     * @param entityTargetLivingEntityEvent An event where an entity is targeting a living entity.
     */
    @EventHandler
    public void onEntityTarget(EntityTargetLivingEntityEvent entityTargetLivingEntityEvent){
        UUID experienceOrbId = entityTargetLivingEntityEvent.getEntity().getUniqueId();
        if(!this.customExperienceManager.isWithinMap(experienceOrbId)){
            return;
        }

        UUID targetId = entityTargetLivingEntityEvent.getTarget().getUniqueId();

        if(!this.customExperienceManager.isCorrectTargetForOrb(experienceOrbId,targetId)){
            entityTargetLivingEntityEvent.setCancelled(true);
        }
    }

    /**
     * Ensures that, when experience is picked up, it isn't picked up by anyone other than the player who caused
     * the experience drop.
     * @param experienceEvent An event where experience has been picked up by a player.
     */
    @EventHandler
    public void onExpPickup(PlayerPickupExperienceEvent experienceEvent){
        ExperienceOrb experienceOrb = experienceEvent.getExperienceOrb();
        UUID orbId = experienceOrb.getUniqueId();
        if(!this.customExperienceManager.isWithinMap(orbId)){
            return;
        }
        if (!this.customExperienceManager.isCorrectTargetForOrb(orbId,
                experienceEvent.getPlayer().getUniqueId())){
            experienceEvent.setCancelled(true);
        }
        int orbProgressAmount = this.customExperienceManager.getExperienceAmount(orbId);
        this.archetypeManager.addProgressionToPlayer(experienceEvent.getPlayer().getUniqueId(),orbProgressAmount);
        this.customExperienceManager.endOrbEffect(orbId);
    }
}

