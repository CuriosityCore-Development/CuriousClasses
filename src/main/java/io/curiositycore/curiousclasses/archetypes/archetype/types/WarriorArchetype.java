package io.curiositycore.curiousclasses.archetypes.archetype.types;

import io.curiositycore.curiousclasses.archetypes.archetype.PlayerArchetype;
import io.curiositycore.curiousclasses.archetypes.archetype.interfaces.ArchetypeBuilder;
import io.curiositycore.curiousclasses.archetypes.skills.interfaces.Skill;
import io.curiositycore.curiousclasses.archetypes.tier.Tier;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.Set;

public class WarriorArchetype extends PlayerArchetype {
    /**
     * Constructor for the initialisation that utilises a builder object to initialise the archetype.
     *
     * @param archetypeBuilder The builder utilised to create the archetype.
     * @param player           The player to attach the archetype to.
     */
    protected WarriorArchetype(ArchetypeBuilder archetypeBuilder, Player player) {
        super(archetypeBuilder, player);
    }
    //TODO Add this Entry init to the archetype builder as this is 100% going to get unwieldy very quickly.
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
