package io.curiositycore.curiousclasses.archetypes.archetype;

import io.curiositycore.curiousclasses.archetypes.archetype.interfaces.Archetype;
import io.curiositycore.curiousclasses.archetypes.archetype.types.ArchetypeBuilder;
import io.curiositycore.curiousclasses.archetypes.progression.ArchetypeProgression;
import io.curiositycore.curiousclasses.archetypes.skills.interfaces.Skill;
import io.curiositycore.curiousclasses.archetypes.tier.Tier;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * Abstract representing the base of any archetype within the plugin.
 */
@Getter
@Setter
public abstract class BaseArchetype implements Archetype {
    /**
     * The name of the archetype.
     */
    protected String archetypeName;

    /**
     * The current tier of the archetype.
     */
    protected Tier archetypeTier;

    /**
     * The uniqueId of the archetype;
     */
    protected UUID archetypeId;

    /**
     * Map containing all skills for each tier, contained within a set.
     */
    protected Map<Tier, Set<Skill>> skillMap;

    /**
     * The progression statistics of the Archetype.
     */
    protected ArchetypeProgression archetypeProgression;

    /**
     * Map that contains Event classes as keys, and the skills that can be triggered by class's Event as the values.
     */
    protected Map<Class<? extends Event>,Set<Skill>> eventSkillSet;

    /**
     * Constructor for the initialisation that utilises a builder object to initialise the archetype.
     * @param archetypeBuilder The builder utilised to create the archetype.
     */
    protected BaseArchetype(ArchetypeBuilder archetypeBuilder, Player player) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        archetypeBuilder.build(this);
        this.setArchetypeId(player.getUniqueId());
    }

}
