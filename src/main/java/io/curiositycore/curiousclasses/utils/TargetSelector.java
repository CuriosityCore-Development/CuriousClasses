package io.curiositycore.curiousclasses.utils;

import org.bukkit.entity.Entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TargetSelector {
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
