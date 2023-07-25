package io.curiositycore.curiousclasses.items;

import net.kyori.adventure.text.Component;

import java.util.UUID;

/**
 * Interface representing the functionality of a custom item within the plugin. Can send messages to the user wielding
 * it and be triggered to remove itself from the wielder (either their hands or armor slot).
 */
public interface CustomItem {
    /**
     * Sends a custom message to the wielder, usually done during interaction.
     * @param wielderId The unique id of the wielder.
     * @param messageToSend The message to send to the wielder.
     */
    void sendInteractionMessageToWielder(UUID wielderId, Component messageToSend);

    /**
     * Removes the item from either the wielder's hand or armor slot.
     * @param wielderId The unique id of the wielder.
     */
    void removeItemFromWielder(UUID wielderId);
}
