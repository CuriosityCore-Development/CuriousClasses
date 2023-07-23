package io.curiositycore.curiousclasses.archetypes.progression;

import com.destroystokyo.paper.event.player.PlayerPickupExperienceEvent;
import io.curiositycore.curiousclasses.archetypes.managers.ArchetypeManager;
import io.curiositycore.curiousclasses.archetypes.managers.CustomExperienceManager;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;

import java.net.http.WebSocket;
import java.util.UUID;

/**
 * Listener for events that could potentially be progression events within the plugin. This includes events that
 * could involve {@linkplain io.curiositycore.curiousclasses.archetypes.progression.ArchetypeExperience ArchetypeExperience}
 * drops.
 */
public class ProgressionListener implements WebSocket.Listener {
    /**
     * Instance of the CustomExperienceManager of the plugin.
     */
    CustomExperienceManager customExperienceManager;

    /**
     * Constructor which initialises the custom experience manager.
     * @param customExperienceManager The plugin's custom experience manager.
     */
    public ProgressionListener(CustomExperienceManager customExperienceManager){
        this.customExperienceManager = customExperienceManager;
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
        if(!this.customExperienceManager.isWithinMap(experienceOrb.getUniqueId())){
            return;
        }
        if (!this.customExperienceManager.isCorrectTargetForOrb(experienceOrb.getUniqueId(),
                experienceEvent.getPlayer().getUniqueId())){
            experienceEvent.setCancelled(true);
        }

    }
}
