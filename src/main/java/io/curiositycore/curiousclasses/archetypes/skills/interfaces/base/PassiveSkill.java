package io.curiositycore.curiousclasses.archetypes.skills.interfaces.base;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import java.util.Set;

/**
 * Interface that represents a skill that has passive effects (not activated manually, but rather provides constant
 * effects to those with the skill).
 */
public interface PassiveSkill<T>{
    /**
     * Sets the effect of the skill.
     */
    void setEffect(T target);
    T getTargets(Entity skillOwner);
}
