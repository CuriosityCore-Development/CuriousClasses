package io.curiositycore.curiousclasses.archetypes.progression;

/**
 * Interface representing the functionality of any progression system within the plugin.
 */
public interface Progression {
    /**
     * Adds to the progression of the Archetype.
     * @param progressionToAdd Progression to add.
     */
    void addProgression(int progressionToAdd);

    /**
     * Removes a portion of progression from the Archetype.
     * @param progressionToRemove Progression to remove.
     */
    void removeProgression(int progressionToRemove);

    /**
     * Gets the current amount of progression of the Archetype.
     * @return The Archetype's current progression.
     */
    int getCurrentProgression();

    /**
     * Resets the target's progression.
     */
    void resetProgression();

    /**
     * Gets the amount of remaining progression required before the Archetype upgrades.
     * @return The amount of progression remaining till upgrade.
     */
    int getProgressionTillCompletion();
}
