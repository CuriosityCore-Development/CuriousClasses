package io.curiositycore.curiousclasses.archetypes.managers;

import io.curiositycore.curiousclasses.archetypes.progression.ArchetypeExperience;

import java.util.Map;
import java.util.UUID;

/**
 * Manager responsible for tracking all {@linkplain
 * io.curiositycore.curiousclasses.archetypes.progression.ArchetypeExperience Archetype Experience} instances created by
 * the plugin.
 */
public class CustomExperienceManager implements Manager<ArchetypeExperience>{
    /**
     * A map of experience orb UUID keys linked to player UUID values. These are essentally the experience orb and their
     * target respectfully.
     */
    private Map<UUID,UUID> experienceIdMap;
    @Override
    public void addToManager(ArchetypeExperience experienceOrbToAdd) {
        this.experienceIdMap.put(experienceOrbToAdd.getExperienceOrbId(),experienceOrbToAdd.getTargetid());
    }

    @Override
    public void removeFromManager(UUID idOfOrbToRemove) {
        this.experienceIdMap.remove(idOfOrbToRemove);
    }

    @Override
    public boolean isWithinMap(UUID orbIdToCheck) {
        return this.experienceIdMap.containsKey(orbIdToCheck);
    }

    /**
     * Check to see if the current target of the experience orb being checked is the linked target found within this
     * manager's map.
     * @param orbId The unique id of the experience orb.
     * @param targetId The unique id of the experience orb's current target.
     * @return True if the target of the experience orb is the same as its custom experience orb target, false if it is
     * not.
     */
    public boolean isCorrectTargetForOrb(UUID orbId, UUID targetId){
        return this.experienceIdMap.get(orbId) == targetId;
    }
}
