package io.curiositycore.curiousclasses.archetypes.archetype.types;

import io.curiositycore.curiousclasses.archetypes.archetype.BaseArchetype;
import io.curiositycore.curiousclasses.archetypes.archetype.interfaces.ArchetypeBuilder;
import io.curiositycore.curiousclasses.archetypes.skills.interfaces.Skill;
import io.curiositycore.curiousclasses.archetypes.skills.skill.RegenOnMobKill;
import io.curiositycore.curiousclasses.archetypes.tier.Tier;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WarriorArchetypeBuilder implements ArchetypeBuilder{
//TODO add the methods for setting properly (they are null atm)
    @Override
    public String setArchetypeName() {
        return null;
    }

    @Override
    public Tier setArchetypeTier() {
        return null;
    }

    @Override
    public Map<Tier, Set<Skill>> setSkillMap() {
        Map<Tier,Set<Skill>> skillMap = new HashMap<>();
        Set<Skill> skillSet = new HashSet<>();
        skillSet.add(new RegenOnMobKill());
        skillMap.put(Tier.TIER_ONE,skillSet);
        return skillMap;
    }
}
