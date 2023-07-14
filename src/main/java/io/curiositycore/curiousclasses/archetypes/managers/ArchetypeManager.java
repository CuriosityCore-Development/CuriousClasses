package io.curiositycore.curiousclasses.archetypes.managers;

import io.curiositycore.curiousclasses.archetypes.archetype.BaseArchetype;

import java.util.HashMap;
import java.util.Map;
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

    public<C extends BaseArchetype> boolean isOfType(Class<C> clazz, UUID archetypeId){
        return this.archetypeMap.get(archetypeId).getClass() == clazz;
    }
}
