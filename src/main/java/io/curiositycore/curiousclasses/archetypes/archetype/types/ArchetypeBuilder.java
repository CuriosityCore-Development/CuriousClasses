package io.curiositycore.curiousclasses.archetypes.archetype.types;

import io.curiositycore.curiousclasses.archetypes.archetype.BaseArchetype;
import io.curiositycore.curiousclasses.archetypes.archetype.interfaces.Builder;
import io.curiositycore.curiousclasses.archetypes.skills.interfaces.Skill;
import io.curiositycore.curiousclasses.archetypes.tier.Tier;
import org.bukkit.event.Event;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Set;

/**
 * Abstract defining the generalisation of a {@link
 * io.curiositycore.curiousclasses.archetypes.archetype.interfaces.Builder Builder} responsible for building {@link
 * io.curiositycore.curiousclasses.archetypes.archetype.BaseArchetype BaseArchetype} instances.
 * @param <T> The type parameter for the builder. Can be any child class of a BaseArchetype.
 */

public abstract class ArchetypeBuilder<T extends BaseArchetype> implements Builder<T> {

   /**
    * The name of the archetype being built.
    */
   protected String archetypeName;

   /**
    * The tier of the archetype being built.
    */
   protected Tier archetypeTier;

   /**
    * The map of skills, related to each tier, of the archetype being built.
    */
   protected Map<Tier, Set<Skill>> skillMap;

   /**
    * The map of skills related to callable bukkit events relevant to the archetype being built.
    */
   protected Map<Class<? extends Event>,Set<Skill>> eventMap;

   @Override
   public void build(BaseArchetype archetypeToBuild) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
      archetypeToBuild.setArchetypeName(setArchetypeName());
      archetypeToBuild.setArchetypeTier(setArchetypeTier());
      archetypeToBuild.setSkillMap(setArchetypeSkillMap());
      archetypeToBuild.setEventSkillSet(setArchetypeEventMap());

   }

   /**
    * Set the archetype's name.
    * @return The archetypes name.
    */
   protected abstract String setArchetypeName();

   /**
    * Set the archetype's tier.
    * @return The archetype's tier
    */
   protected abstract Tier setArchetypeTier();

   /**
    * Set the archetype's skill map.
    * @return The archetype's skill map.
    */
   protected abstract Map<Tier, Set<Skill>> setArchetypeSkillMap();

   /**
    * Set the archetype's event map.
    * @return The archetype's event map.
    */
   protected abstract Map<Class<? extends Event>,Set<Skill>> setArchetypeEventMap();

   /**
    * Returns the skill set for a specific tier of the archetype.
    * @param tierOfSet The tier of the skill set to get.
    * @return The skill set of the requested archetype tier.
    */
   protected abstract Set<Skill> initialiseTierSet(Tier tierOfSet);
}
