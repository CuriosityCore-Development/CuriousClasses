package io.curiositycore.curiousclasses.archetypes.managers;

import java.util.UUID;

/**
 * Interface represents a generalisation of any manager within the plugin. Managers are to be responsible for the
 * locating, manipulation and functionality of any objects within this plugin.
 *
 * @param <O> Generic object that the manager is responsible for.
 */
public interface Manager<O> {
    /**
     * Adds an object to the manager.
     * @param objectToAdd The object to be added.
     */
    void addToManager(O objectToAdd);

    /**
     * Removes an object from the manager.
     * @param objectId The unique id of the object to be removed.
     */
    void removeFromManager(UUID objectId);
}
