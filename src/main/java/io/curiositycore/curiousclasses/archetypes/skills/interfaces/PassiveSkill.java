package io.curiositycore.curiousclasses.archetypes.skills.interfaces;

/**
 * Interface that represents a skill that has passive effects (not activated manually, but rather provides constant
 * effects to those with the skill).
 */
public interface PassiveSkill extends Skill{
    /**
     * Sets the effect of the skill.
     */
    void setEffect();
}
