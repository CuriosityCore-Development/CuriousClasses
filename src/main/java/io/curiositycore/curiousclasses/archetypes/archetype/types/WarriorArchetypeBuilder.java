package io.curiositycore.curiousclasses.archetypes.archetype.types;

import io.curiositycore.curiousclasses.archetypes.skills.interfaces.Skill;
import io.curiositycore.curiousclasses.archetypes.skills.skill.RegenOnMobKill;
import io.curiositycore.curiousclasses.archetypes.tier.Tier;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDeathEvent;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Builder for the {@link io.curiositycore.curiousclasses.archetypes.archetype.types.WarriorArchetype WarriorArchetype}.
 */
public class WarriorArchetypeBuilder extends ArchetypeBuilder<WarriorArchetype>{
    //TODO may need removing in place of new config system.
    private Set<Skill> ENTITY_DEATH_SKILL_SET = new HashSet<>();

    /**
     * A map of skills, as related to the tier the skills belong to for the archetype.
     */
    private static final Map<Tier, Set<Skill>> skillMap = new HashMap<>();

    /**
     * A map of skills, as related to an event relevant to the archetype.
     */
    private static final Map<Class<? extends Event>, Set<Skill>> eventMap = new HashMap<>();

    @Override
    public String setArchetypeName() {
        return "Warrior";
    }

    @Override
    public Tier setArchetypeTier() {
        return Tier.TIER_ONE;
    }

    @Override
    protected Map<Tier, Set<Skill>> setArchetypeSkillMap() {

        return null;
    }

    @Override
    protected Map<Class<? extends Event>, Set<Skill>> setArchetypeEventMap() {
        return null;
    }

    //TODO The approach to explore here is having a config setup that allows for users to define what skills are to be
    //     applied to what archetype. This could expand later into a system where the config allows for new skills and
    //     artefacts to be made (quite similar to mythic mobs, and might indeed utilise their api)
    @Override
    protected Set<Skill> initialiseTierSet(Tier tierOfSet) {

        return null;
    }


}
