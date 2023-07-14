package io.curiositycore.curiousclasses.archetypes.skills.interfaces;

import io.curiositycore.curiousclasses.archetypes.tier.Tier;
import org.bukkit.entity.Player;

/**
 * Interface that represents a Skill within the plugin.
 */
public interface Skill {
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

    boolean meetsRequirements(Player player);

}
