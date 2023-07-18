package io.curiositycore.curiousclasses.archetypes.skills.interfaces.base;

import org.bukkit.entity.Entity;


/**
 * Interface that represents a skill that has active effects (Activated manually by those who posses theh skill).
 */
public interface ActiveSkill<T>{
    /**
     * Activate the skills ability
     */
    void activateAbility(T target);

    /**
     * Get the targets of the active skill.
     * @param skillOwner The owner of the skill being activated.
     * @return The targets the skill is going to effect.
     */
    T getTargets(Entity skillOwner);

}
