package io.curiositycore.curiousclasses.archetypes.skills.skill;

import io.curiositycore.curiousclasses.archetypes.skills.interfaces.Skill;
import lombok.Getter;


/**
 * Abstract to represent the general representation of a base skill within the plugin. All skill types will be built
 * on top of this abstract, supplemented by interfaces.
 */
public abstract class BaseSkill<T> implements Skill<T> {

    /**
     * Represents if the skill is active or not.
     */
    @Getter
    protected boolean isSkillActive = false;







}
