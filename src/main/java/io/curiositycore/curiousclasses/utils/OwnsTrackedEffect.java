package io.curiositycore.curiousclasses.utils;

/**
 * Interface representing the functionality of an object instance that has some sort of in-game effect that tracks the
 * subject of the object instance.
 */
public interface OwnsTrackedEffect {
    /**
     * Initializes the tracking effect.
     */
    void initEffect();

    /**
     * Ends the tracking effect.
     */
    void endEffect();
}
