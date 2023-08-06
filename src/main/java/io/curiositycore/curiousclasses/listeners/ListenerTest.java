package io.curiositycore.curiousclasses.listeners;

import io.curiositycore.curiousclasses.archetypes.archetype.types.WarriorArchetype;
import io.curiositycore.curiousclasses.archetypes.archetype.types.WarriorArchetypeBuilder;
import io.curiositycore.curiousclasses.archetypes.managers.ArchetypeManager;

import io.curiositycore.curiousclasses.archetypes.managers.CustomExperienceManager;
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
    private ArchetypeManager archetypeManager;
    public ListenerTest(ArchetypeManager archetypeManager){
        this.archetypeManager = archetypeManager;
    }

    @EventHandler
    public void onMobKill(EntityDeathEvent entityDeathEvent){
        Bukkit.getServer().getLogger().info("event triggered here");
        LivingEntity entityKilled = entityDeathEvent.getEntity();
        if(!(entityDeathEvent.getEntity() instanceof Monster)){
            Bukkit.getServer().getLogger().info("Wasnt a monster");
            return;
        }
        Bukkit.getServer().getLogger().info("killer check here");
        Player killer = entityKilled.getKiller();
        Bukkit.getServer().getLogger().info("aserrtion check");
        assert killer != null;
        if(!this.archetypeManager.isWithinMap(Objects.requireNonNull(killer).getUniqueId())){
            Bukkit.getServer().getLogger().info("Was not in the skill map");
            return;

        }
        if(!this.archetypeManager.isOfType(WarriorArchetype.class,killer.getUniqueId())){
            Bukkit.getServer().getLogger().info("Was not a warrior");
            return;
        }
        Bukkit.getServer().getLogger().info("Ability go brt");
        this.archetypeManager.activateAbility(entityDeathEvent,killer.getUniqueId(),killer);
        Bukkit.getServer().getLogger().info("dropping the xp");
        this.archetypeManager.spawnExperienceOrb(killer.getUniqueId(),entityDeathEvent.getEntity().getEyeLocation());
    }
    @EventHandler
    public void onPlayerJoinTest(PlayerJoinEvent playerJoinEvent) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        WarriorArchetype warriorArchetype = new WarriorArchetype(new WarriorArchetypeBuilder(), playerJoinEvent.getPlayer());
        this.archetypeManager.addToManager(warriorArchetype);
    }
}
