package io.curiositycore.curiousclasses.archetypes.skills.interfaces;

/**
 * Interface that represents skills that have a set duration.
 */
public interface TimedSkill {
    /**
     * Set the duration of the skill. Is a public class to allow for modifiers to
     * be applied on activation.
     * @param timeInSeconds The time of the skill's duration in seconds.
     */
    void voidSetDuration(int timeInSeconds);
}
