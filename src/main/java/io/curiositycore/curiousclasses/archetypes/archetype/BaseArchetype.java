package io.curiositycore.curiousclasses.archetypes.archetype;

import io.curiositycore.curiousclasses.archetypes.archetype.interfaces.Archetype;
import io.curiositycore.curiousclasses.archetypes.archetype.interfaces.ArchetypeBuilder;
import io.curiositycore.curiousclasses.archetypes.tier.Tier;
import lombok.Getter;

import java.util.UUID;

/**
 * Abstract representing the base of any archetype within the plugin.
 */
@Getter
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


    //TODO This is not good enough, there needs to be a more focused class type for individual archetypes to be
    //     constructed from original data (Perhaps a builder pattern implementation?)
    /**
     * Constructor for the initialisation that utilises a builder object to initialise the archetype.
     * @param archetypeBuilder The builder utilised to create the archetype.
     */
    protected BaseArchetype(ArchetypeBuilder archetypeBuilder){
        archetypeBuilder.build(this);

    }

}
