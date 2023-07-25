package io.curiositycore.curiousclasses.items;

import java.util.UUID;

/**
 * Interface representing the functionality of a custom item that has an active ability.
 */
public interface ActiveAbilityHolder extends CustomItem{

    /**
     * Activate the ability of the item.
     * @param wielderId The unique id of the item's wielder.
     */
    void activateAbility(UUID wielderId);

    /**
     * Cancel the item ability's activation.
     * @param wielderId The unique id of the item's wielder.
     */
    void cancelAbility(UUID wielderId);
}
