package io.curiositycore.curiousclasses.listeners;

import io.curiositycore.curiousclasses.archetypes.archetype.types.WarriorArchetype;
import io.curiositycore.curiousclasses.archetypes.archetype.types.WarriorArchetypeBuilder;
import io.curiositycore.curiousclasses.archetypes.managers.ArchetypeManager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.UUID;
/**
 * Test class to explore how best to approach the event listeners of the plugin. <i>Temporary so will not have full
 * docs</i>.
 */
public class ListenerTest implements Listener {
    ArchetypeManager archetypeManager;
    public ListenerTest(ArchetypeManager archetypeManager){
        this.archetypeManager = archetypeManager;
    }

    @EventHandler
    public void onMobKill(EntityDeathEvent entityDeathEvent){
        LivingEntity entityKilled = entityDeathEvent.getEntity();
        if(!(entityDeathEvent.getEntity() instanceof Monster)){
            Bukkit.getLogger().info("Wasnt a monster");
            return;
        }
        Player killer = entityKilled.getKiller();
        assert killer != null;
        if(!this.archetypeManager.isWithinMap(Objects.requireNonNull(killer).getUniqueId())){
            Bukkit.getLogger().info("Was not in the skill map");
            return;

        }
        if(!this.archetypeManager.isOfType(WarriorArchetype.class,killer.getUniqueId())){
            Bukkit.getLogger().info("Was not a warrior");
            return;
        }

        this.archetypeManager.activateAbility(entityDeathEvent,killer.getUniqueId(),killer);
    }
    @EventHandler
    public void onPlayerJoinTest(PlayerJoinEvent playerJoinEvent) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        WarriorArchetype warriorArchetype = new WarriorArchetype(new WarriorArchetypeBuilder(), playerJoinEvent.getPlayer());
        this.archetypeManager.addToManager(warriorArchetype);
    }
}
