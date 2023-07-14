package io.curiositycore.curiousclasses.archetypes.archetype.types;

import io.curiositycore.curiousclasses.archetypes.archetype.PlayerArchetype;
import io.curiositycore.curiousclasses.archetypes.archetype.interfaces.ArchetypeBuilder;
import io.curiositycore.curiousclasses.archetypes.skills.interfaces.Skill;
import io.curiositycore.curiousclasses.archetypes.tier.Tier;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.Set;

public class MageArchetype extends PlayerArchetype {
    /**
     * Constructor for the initialisation that utilises a builder object to initialise the archetype.
     *
     * @param archetypeBuilder The builder utilised to create the archetype.
     * @param player           The player to attach the archetype to.
     */
    protected MageArchetype(ArchetypeBuilder archetypeBuilder, Player player) {
        super(archetypeBuilder, player);
    }

    @Override
    public Map.Entry<Tier, Set<Skill>> initialiseTierSkillSet(Tier skillTier) {
        return null;
    }

    @Override
    public void upgradeTier() {

    }

    @Override
    public void downgradeTier() {

    }
}
