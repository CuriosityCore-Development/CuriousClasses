package io.curiositycore.curiousclasses.listeners;

import io.curiositycore.curiousclasses.archetypes.managers.ArchetypeManager;
import org.bukkit.event.Listener;

/**
 * Class responsible for the managing of events that involve items within the plugin. This includes both utilisation nd
 * restriction of certain items (custom and vanilla) depending on {@linkplain
 * io.curiositycore.curiousclasses.archetypes.archetype.PlayerArchetype Player Archetype}.
 */
public class ItemListener implements Listener {
    /**
     * The singleton instance of the Archetype Manager.
     */
    ArchetypeManager archetypeManager;

    /**
     * Constructor which initialises the Archetype Manager.
     * @param archetypeManager The singleton instance of the ArchetypeManager.
     */
    public ItemListener(ArchetypeManager archetypeManager){
        this.archetypeManager = archetypeManager;
    }
    //TODO Event to stop wearing armor of certain type (custom and vanilla, might need to be two classes).
    //TODO Event to stop usage of "special abilities that are related to items", as of now utilise the interfaces within
    //     the items package. If required, feel free to start adding abstracts and other classes to the items package to
    //     aid in this branch's functionality.
}
