package io.curiositycore.curiousclasses.archetypes.archetype.types;

import io.curiositycore.curiousclasses.archetypes.archetype.PlayerArchetype;
import io.curiositycore.curiousclasses.archetypes.skills.interfaces.Skill;
import io.curiositycore.curiousclasses.archetypes.tier.Tier;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Set;

public class WarriorArchetype extends PlayerArchetype {
    /**
     * Constructor for the initialisation that utilises a builder object to initialise the archetype.
     *
     * @param archetypeBuilder The builder utilised to create the archetype.
     * @param player           The player to attach the archetype to.
     */
    public WarriorArchetype(ArchetypeBuilder archetypeBuilder, Player player) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        super(archetypeBuilder, player);
    }
    @Override
    public void upgradeTier() {

    }

    @Override
    public void downgradeTier() {

    }
}
