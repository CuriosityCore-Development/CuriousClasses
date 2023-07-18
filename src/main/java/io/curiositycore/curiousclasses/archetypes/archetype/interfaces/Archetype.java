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
     * Upgrade the tier of the archetype.
     */
    void upgradeTier();

    /**
     * Downgrade the tier of the archetype.
     */
    void downgradeTier();
}
