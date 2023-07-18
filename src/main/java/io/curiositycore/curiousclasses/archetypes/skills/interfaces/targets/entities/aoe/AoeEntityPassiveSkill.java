package io.curiositycore.curiousclasses.archetypes.skills.interfaces.targets.entities.aoe;

import io.curiositycore.curiousclasses.archetypes.skills.interfaces.base.PassiveSkill;
import org.bukkit.entity.LivingEntity;

import java.util.Set;

public interface AoeEntityPassiveSkill<T extends LivingEntity> extends PassiveSkill<Set<T>> {
}
