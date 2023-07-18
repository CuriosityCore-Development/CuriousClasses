package io.curiositycore.curiousclasses.utils;

import org.bukkit.entity.Entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Utility class used to determine targets for various abilities and effects within the plugin.
 */
public class TargetSelector {
    /**
     * Finds the targets within a bounding box (essential AoE) to apply an effect to.
     * @param centralEntity The entity around which the bounding box is centralised.
     * @param aoeRadius The radius of the AoE effect, in blocks.
     * @return The number of targets effected by the AoE effect.
     * @param <T> The type parameter of the targets to locate. This type parameter can only be a class that is an
     *           instance of an Entity.
     */
    public static<T extends Entity> Set<T> getTargetsInRadius(Entity centralEntity,int aoeRadius){
        List<Entity> targetList = centralEntity.getNearbyEntities(aoeRadius,aoeRadius,aoeRadius);
        Set<T> targetSet = new HashSet<>();
        targetList.forEach(target-> {
            if((T) target != null){
                targetSet.add((T) target);

            }
        });
        return targetSet;
    }
}
