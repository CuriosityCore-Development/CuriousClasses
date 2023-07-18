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

    public<C extends BaseArchetype> boolean isOfType(Class<C> clazz, UUID archetypeId){
        return this.archetypeMap.get(archetypeId).getClass() == clazz;
    }
    //TODO add event checks, i.e. checks to be done when an ability is triggered by an event (probably best to add to
    //     the passive skill interface. Or perhaps adding a new "reactive skill" interface that extends PassiveSkill.
    public <T> void activateAbility(Event event, UUID archeTypeId, T targetOfAbility){
        this.archetypeMap.get(archeTypeId).getEventSkillSet().get(event.getClass()).forEach(skill->skill.activate(targetOfAbility));
    }
}
