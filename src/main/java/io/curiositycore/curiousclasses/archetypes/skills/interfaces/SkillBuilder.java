package io.curiositycore.curiousclasses.archetypes.skills.interfaces;

import io.curiositycore.curiousclasses.archetypes.archetype.interfaces.Builder;
import io.curiositycore.curiousclasses.archetypes.tier.Tier;

/**
 * Interface that represents a generalisation of a Builder that constructs skills.
 */
public interface SkillBuilder extends Builder<Skill> {
    /**
     * Get the skill's name for the purposes of setting.
     * @return The skills name.
     */
    String setSkillName();

    /**
     * Get the skill's tier for the purposes of setting.
     * @return The skill's tier.
     */
    Tier setSkillTier();
}
