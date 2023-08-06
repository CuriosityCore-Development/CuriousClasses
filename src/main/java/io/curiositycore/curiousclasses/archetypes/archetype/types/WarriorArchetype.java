package io.curiositycore.curiousclasses.archetypes.archetype.types;

import io.curiositycore.curiousclasses.archetypes.archetype.PlayerArchetype;
import io.curiositycore.curiousclasses.archetypes.progression.types.WarriorExperienceOrb;
import org.bukkit.entity.Player;
import java.lang.reflect.InvocationTargetException;

/**
 * Test class of the general functionality of the skill system. <i>Temporary so will not have full docs</i>
 */
public class WarriorArchetype extends PlayerArchetype {
    /**
     * Constructor for the initialisation that utilises a builder object to initialise the archetype.
     *
     * @param archetypeBuilder The builder utilised to create the archetype.
     * @param player           The player to attach the archetype to.
     */
    public WarriorArchetype(ArchetypeBuilder archetypeBuilder, Player player) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        super(archetypeBuilder, player);
        this.archetypeExperience = new WarriorExperienceOrb();
    }
    @Override
    public void upgradeTier() {

    }

    @Override
    public void downgradeTier() {

    }
}
