package io.curiositycore.curiousclasses.archetypes.archetype.interfaces;

import io.curiositycore.curiousclasses.archetypes.skills.interfaces.Skill;
import io.curiositycore.curiousclasses.archetypes.tier.Tier;

import java.util.Map;
import java.util.Set;

/**
 * Interface represents any archetype within this plugin. A settable role that provides owners with unique abilities and
 * effects and skills.
 */
public interface Archetype {
    /**
     * Initialisies a map entry with a set of skills for the entry's <code>Value</code> and the corresponding tier for
     * the skills to the entry's <code>Key</code>.
     * @param skillTier The tier of the skill.
     */
    Map.Entry<Tier,Set<Skill>> initialiseTierSkillSet(Tier skillTier);

    /**
     * Upgrade the tier of the archetype.
     */
    void upgradeTier();

    /**
     * Downgrade the tier of the archetype.
     */
    void downgradeTier();
}
