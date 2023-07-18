package io.curiositycore.curiousclasses.archetypes.skills.interfaces.targets.entities.aoe;

import io.curiositycore.curiousclasses.archetypes.skills.interfaces.base.ActiveSkill;
import org.bukkit.entity.LivingEntity;

import java.util.Set;

public interface AoeEntityActiveSkill <T extends LivingEntity> extends ActiveSkill<Set<T>> {

}
