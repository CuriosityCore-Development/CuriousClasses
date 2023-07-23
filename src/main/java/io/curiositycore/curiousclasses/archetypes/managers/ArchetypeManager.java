package io.curiositycore.curiousclasses.archetypes.managers;

import io.curiositycore.curiousclasses.archetypes.archetype.BaseArchetype;
import io.curiositycore.curiousclasses.archetypes.skills.interfaces.Skill;
import io.curiositycore.curiousclasses.archetypes.tier.Tier;
import org.bukkit.event.Event;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * Manager responsible for the locating, manipulation and functionality of any Archetypes within this plugin.
 */
public class ArchetypeManager implements Manager<BaseArchetype>{
    /**
     * The map that stores all the current archetypes within the plugin, with keys that correspond to the unique id of
     * each archetype. <p>
     *
     * This allows for ease of retrieval for the purposes of events and general functionality.
     */
    Map<UUID, BaseArchetype> archetypeMap = new HashMap<>();
    @Override
    public void addToManager(BaseArchetype baseArchetypeToAdd) {
        this.archetypeMap.put(baseArchetypeToAdd.getArchetypeId(), baseArchetypeToAdd);
    }

    @Override
    public void removeFromManager(UUID archetypeId) {
        this.archetypeMap.remove(archetypeId);
    }

    @Override
    public boolean isWithinMap(UUID uuid) {
        return this.archetypeMap.containsKey(uuid);
    }

    /**
     * Checks to see if the archetype is of the specified class.
     * @param clazz The specified class of archetype.
     * @param archetypeId The id of the archetype to check.
     * @return True if the checked archetype is of the specified class, false if it's not.
     * @param <C> The type parameter of the class to check, that specifies it must be a child
     *           class of the BaseArchetype abstract.
     */
    public<C extends BaseArchetype> boolean isOfType(Class<C> clazz, UUID archetypeId){
        return this.archetypeMap.get(archetypeId).getClass() == clazz;
    }

    /**
     * Activates an ability of the specified archetype.
     * @param event The event that triggered the ability.
     * @param archeTypeId The id of the archetype being triggered.
     * @param targetOfAbility The target of the ability.
     * @param <T> The type parameter that represents the target of the ability.
     */
    public <T> void activateAbility(Event event, UUID archeTypeId, T targetOfAbility){
        this.archetypeMap.get(archeTypeId).getEventSkillSet().get(event.getClass()).forEach(skill->skill.activate(targetOfAbility));
    }

    /**
     * Upgrades an Archetype to its next tier.
     * @param archetypeId The unique id of the Archetype to upgrade.
     */
    public void increaseArchetypeTier(UUID archetypeId){
        this.archetypeMap.get(archetypeId).upgradeTier();
    }

    /**
     * Downgrades an Archetype to its previous tier.
     * @param archetypeId The unique id of the Archetype to downgrade.
     */
    public void decreaseArchetypeTier(UUID archetypeId){
        this.archetypeMap.get(archetypeId).downgradeTier();
    }

    /**
     * Adds progress to the specified Archetype.
     * @param archetypeId The unique id of the Archetype.
     * @param progressionAmount The amount of progress to add to the Archetype.
     */
    public void addProgressionToPlayer(UUID archetypeId, int progressionAmount){
        this.archetypeMap.get(archetypeId).getArchetypeProgression().addProgression(progressionAmount);
    }
}
