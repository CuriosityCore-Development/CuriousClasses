package io.curiositycore.curiousclasses.archetypes.archetype;

import io.curiositycore.curiousclasses.archetypes.archetype.interfaces.ArchetypeBuilder;
import io.curiositycore.curiousclasses.archetypes.archetype.interfaces.Playable;
import org.bukkit.entity.Player;

/**
 * An archetype that is attachable to a <code>Player</code> instance. This has been created for the sake of
 * future-proofing the plugin. For example, if an archetype that could be attached to mobs was required in future.
 */
public abstract class PlayerArchetype extends BaseArchetype implements Playable {
    /**
     * The player who this archetype is attached to.
     */
    Player archetypeOwner;
    /**
     * Constructor for the initialisation that utilises a builder object to initialise the archetype.
     *
     * @param archetypeBuilder The builder utilised to create the archetype.
     * @param player The player to attach the archetype to.
     */
    protected PlayerArchetype(ArchetypeBuilder archetypeBuilder, Player player) {
        super(archetypeBuilder);
        this.archetypeOwner = player;
        this.archetypeId = player.getUniqueId();

    }
}
