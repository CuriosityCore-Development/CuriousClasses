package io.curiositycore.curiousclasses.archetypes.archetype.types;

import io.curiositycore.curiousclasses.archetypes.archetype.BaseArchetype;
import io.curiositycore.curiousclasses.archetypes.archetype.interfaces.ArchetypeBuilder;
import io.curiositycore.curiousclasses.archetypes.skills.interfaces.Skill;
import io.curiositycore.curiousclasses.archetypes.skills.skill.RegenOnMobKill;
import io.curiositycore.curiousclasses.archetypes.tier.Tier;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityEvent;

import java.util.*;

public class WarriorArchetypeBuilder implements ArchetypeBuilder{
//TODO add the methods for setting properly (they are null atm)
    @Override
    public String setArchetypeName() {
        return "Warrior";
    }

    @Override
    public Tier setArchetypeTier() {
        return Tier.TIER_ONE;
    }

    @Override
    public Map<Tier, Set<Skill>> setSkillMap() {
        Map<Tier,Set<Skill>> skillMap = new HashMap<>();
        Set<Skill> skillSet = new HashSet<>();
        skillSet.add(new RegenOnMobKill());
        skillMap.put(Tier.TIER_ONE,skillSet);

        return skillMap;
    }

    @Override
    public Map<Class<? extends Event>, Set<Skill>> setEventMap() {
        Map<Class<? extends Event>,Set<Skill>> eventMap = new HashMap<>();
        Set<Skill> skillSet = new HashSet<>();
        skillSet.add(new RegenOnMobKill());
        eventMap.put(EntityDeathEvent.class,skillSet);
        return eventMap;
    }

}
