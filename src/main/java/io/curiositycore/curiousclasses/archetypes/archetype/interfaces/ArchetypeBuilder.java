package io.curiositycore.curiousclasses.archetypes.archetype.interfaces;

import io.curiositycore.curiousclasses.archetypes.archetype.BaseArchetype;
import io.curiositycore.curiousclasses.archetypes.tier.Tier;

/**
 * Interface represents the generalisation of any builder responsible for constructing archetypes.
 */
public interface ArchetypeBuilder extends Builder<BaseArchetype> {
    /**
     * Get the archetype's name for the purposes of setting.
     * @return The archetype's name.
     */
    String setArchetypeName();
    /**
     * Get the archetype's tier for the purposes of setting.
     * @return The archetype's tier.
     */
    Tier setArchetypeTier();

}
