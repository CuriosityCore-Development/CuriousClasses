package io.curiositycore.curiousclasses.archetypes.archetype.interfaces;

import io.curiositycore.curiousclasses.archetypes.archetype.BaseArchetype;
import io.curiositycore.curiousclasses.archetypes.skills.interfaces.Skill;
import io.curiositycore.curiousclasses.archetypes.tier.Tier;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * Interface represents the generalisation of any builder responsible for constructing archetypes.
 */
public interface ArchetypeBuilder extends Builder<BaseArchetype> {
    /**
     * Get the archetype's name, for the purposes of setting.
     * @return The archetype's name.
     */
    String setArchetypeName();
    /**
     * Get the archetype's tier, for the purposes of setting.
     * @return The archetype's tier.
     */
    Tier setArchetypeTier();

    /**
     * Get the archetype's skill map, for the purposes of setting.
     * @return
     */
    Map<Tier, Set<Skill>> setSkillMap();
    Map<Class<? extends Event>,Set<Skill>> setEventMap();

    /**
     * Override of build that ensures that all the main properties are initialised correctly.
     * @param baseArchetype The archetype to correctly initialise.
     */
    @Override
    default void build(BaseArchetype baseArchetype){
        baseArchetype.setArchetypeName(setArchetypeName());
        baseArchetype.setArchetypeTier(setArchetypeTier());
        baseArchetype.setSkillMap(setSkillMap());
        baseArchetype.setEventSkillSet(setEventMap());
    }

}
