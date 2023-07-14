package io.curiositycore.curiousclasses.listeners;

import io.curiositycore.curiousclasses.archetypes.archetype.types.WarriorArchetype;
import io.curiositycore.curiousclasses.archetypes.archetype.types.WarriorArchetypeBuilder;
import io.curiositycore.curiousclasses.archetypes.managers.ArchetypeManager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Monster;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Objects;
import java.util.UUID;
//TODO determine best way to set up the chain of calls to get the skill.
public class ListenerTest implements Listener {
    ArchetypeManager archetypeManager;
    public ListenerTest(ArchetypeManager archetypeManager){
        this.archetypeManager = archetypeManager;
    }

    //TODO method to call skill not added yet.
    @EventHandler
    public void onMobKill(EntityDeathEvent entityDeathEvent){
        if(!(entityDeathEvent.getEntity() instanceof Monster)){
            Bukkit.getLogger().info("Wasnt a monster");
            return;
        }
        if(this.archetypeManager.isWithinMap(Objects.requireNonNull(entityDeathEvent.getEntity().getKiller()).getUniqueId())){
            Bukkit.getLogger().info("Got to activation");
            this.archetypeManager.isOfType(WarriorArchetype.class,entityDeathEvent.getEntity().getKiller().getUniqueId());
        }
        Bukkit.getLogger().info("Got to end so no leather helmet");
    }
    @EventHandler
    public void onPlayerJoinTest(PlayerJoinEvent playerJoinEvent){
        UUID playerId = playerJoinEvent.getPlayer().getUniqueId();
        WarriorArchetype warriorArchetype = new WarriorArchetype(new WarriorArchetypeBuilder(), playerJoinEvent.getPlayer());
        this.archetypeManager.addToManager(warriorArchetype);
    }
}
