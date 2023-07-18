package io.curiositycore.curiousclasses.archetypes.archetype.types;

import io.curiositycore.curiousclasses.archetypes.archetype.BaseArchetype;
import io.curiositycore.curiousclasses.archetypes.archetype.interfaces.Builder;
import io.curiositycore.curiousclasses.archetypes.skills.interfaces.Skill;
import io.curiositycore.curiousclasses.archetypes.tier.Tier;
import org.bukkit.event.Event;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Set;

public abstract class ArchetypeBuilder<T extends BaseArchetype> implements Builder<T> {
   protected String archetypeName;
   protected Tier archetypeTier;
   protected Map<Tier, Set<Skill>> skillMap;
   protected Map<Class<? extends Event>,Set<Skill>> eventMap;


   @Override
   public void build(BaseArchetype archetypeToBuild) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
      archetypeToBuild.setArchetypeName(setArchetypeName());
      archetypeToBuild.setArchetypeTier(setArchetypeTier());
      archetypeToBuild.setSkillMap(setArchetypeSkillMap());
      archetypeToBuild.setEventSkillSet(setArchetypeEventMap());

   }
   protected abstract String setArchetypeName();
   protected abstract Tier setArchetypeTier();
   protected abstract Map<Tier, Set<Skill>> setArchetypeSkillMap();
   protected abstract Map<Class<? extends Event>,Set<Skill>> setArchetypeEventMap();
   protected abstract Set<Skill> initialiseTierSet(Tier tierOfSet);
}
