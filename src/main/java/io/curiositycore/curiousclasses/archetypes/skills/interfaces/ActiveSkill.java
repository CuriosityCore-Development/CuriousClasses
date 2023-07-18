package io.curiositycore.curiousclasses.archetypes.skills.interfaces;

import org.bukkit.entity.Player;

/**
 * Interface that represents a skill that has active effects (Activated manually by those who posses theh skill).
 */
public interface ActiveSkill{
    /**
     * Activate the skills ability
     */
    void activateAbility(Player player);

}
