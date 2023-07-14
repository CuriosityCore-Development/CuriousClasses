package io.curiositycore.curiousclasses.archetypes.skills.skill;

import io.curiositycore.curiousclasses.archetypes.skills.interfaces.Skill;
import io.curiositycore.curiousclasses.archetypes.skills.interfaces.SkillBuilder;
import io.curiositycore.curiousclasses.archetypes.tier.Tier;

/**
 * Abstract to represent the general representation of a base skill within the plugin. All skill types will be built
 * on top of this abstract, supplemented by interfaces.
 */
public abstract class BaseSkill implements Skill {
    /**
     * The name of the skill.
     */
    String skillName;
    /**
     * The Tier of the skill.
     */
    Tier skillTier;
    /**
     * Constructor that utilises a builder object to initialise the skll.
     *
     * @param skillBuilder The builder utilised to create the skill.
     */


}
