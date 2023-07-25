package io.curiositycore.curiousclasses.items;

import java.util.UUID;

/**
 * Interface representing the functionality of a custom item that has an active ability.
 */
public interface PassiveAbilityHolder extends CustomItem{
    /**
     * Triggers the ability of the item.
     * @param wielderId The unique id of the item's wielder.
     */
    void triggerPassiveAbility(UUID wielderId);
    /**
     * Suppress the item's passive ability.
     * @param wielderId The unique id of the item's wielder.
     */
    void suppressPassiveAbility(UUID wielderId);
}

