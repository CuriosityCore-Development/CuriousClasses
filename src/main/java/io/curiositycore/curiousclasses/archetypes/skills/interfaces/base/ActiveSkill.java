package io.curiositycore.curiousclasses.archetypes.skills.interfaces.base;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import java.util.Set;

/**
 * Interface that represents a skill that has active effects (Activated manually by those who posses theh skill).
 */
public interface ActiveSkill<T>{
    /**
     * Activate the skills ability
     */
    void activateAbility(T target);
    T getTargets(Entity archetypeOwner);

}
