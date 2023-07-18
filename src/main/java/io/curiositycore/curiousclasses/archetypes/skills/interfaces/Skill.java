package io.curiositycore.curiousclasses.archetypes.skills.interfaces;

import io.curiositycore.curiousclasses.archetypes.tier.Tier;
import org.bukkit.entity.Player;

/**
 * Interface that represents a Skill within the plugin.
 */
public interface Skill<T> {
    /**
     * Get the name of the skill.
     * @return The name of the skill.
     */
    String getName();

    /**
     * Get the tier of the skill.
     * @return The tier of the skill.
     */
    Tier getTier();

    /**
     * Check to see if the player meets the requirements needed for skill's effect.
     * @param player The player to check
     * @return True if they meet the skills requirements, false if they do not.
     */
    boolean meetsRequirements(Player player);

    /**
     * Activates the skill's effects.
     * @param skillOwner The owner of the skill being activated.
     */

    void activate(T skillOwner);

}
