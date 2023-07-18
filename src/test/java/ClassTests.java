import be.seeseemelk.mockbukkit.ChunkMock;
import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import be.seeseemelk.mockbukkit.WorldMock;
import be.seeseemelk.mockbukkit.entity.EntityMock;
import be.seeseemelk.mockbukkit.entity.LivingEntityMock;
import be.seeseemelk.mockbukkit.entity.MobMock;
import be.seeseemelk.mockbukkit.entity.PlayerMock;
import io.curiositycore.curiousclasses.CuriousClasses;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ClassTests {
    private int initialDeposit;
    private ServerMock server;
    private PlayerMock player;
    private CuriousClasses curiousClasses;

    @Test
    public void warriorEffectTest(){
        if(this.server == null){
            this.server = MockBukkit.getOrCreateMock();
            this.curiousClasses = MockBukkit.load(CuriousClasses.class);
            this.player = this.server.addPlayer();
            this.server.getPluginManager().callEvent(new PlayerJoinEvent(this.player, Component.text("Test")));
            this.server.addSimpleWorld("test");
            WorldMock worldMock = (WorldMock) this.server.getWorlds().get(0);

            this.player.getWorld();
            LivingEntityMock mockEntity = (LivingEntityMock) worldMock.spawnEntity(new Location(worldMock,0,0,0), EntityType.SKELETON);
            mockEntity.setKiller(this.player);
            List<ItemStack> itemsDropped = new ArrayList<>();
            ItemStack itemStack = new ItemStack(Material.LEATHER_HELMET);
            this.player.getInventory().setHelmet(itemStack);
            long initialTime = System.nanoTime();
            this.server.getPluginManager().callEvent(new EntityDeathEvent((LivingEntity) mockEntity, itemsDropped));
            long finalTime = System.nanoTime()-initialTime;
            System.out.println(finalTime+" Nanoseconds");
            Assert.assertTrue(this.player.hasPotionEffect(PotionEffectType.REGENERATION));

        }

    }

    @Test
    public void warriorEffectTestNoHelmet(){
            this.server = MockBukkit.getOrCreateMock();
            this.curiousClasses = MockBukkit.load(CuriousClasses.class);
            this.player = this.server.addPlayer();
            this.server.getPluginManager().callEvent(new PlayerJoinEvent(this.player, Component.text("Test")));
            this.server.addSimpleWorld("test");
            WorldMock worldMock = (WorldMock) this.server.getWorlds().get(0);

            this.player.getWorld();
            LivingEntityMock mockEntity = (LivingEntityMock) worldMock.spawnEntity(new Location(worldMock,0,0,0), EntityType.SKELETON);
            mockEntity.setKiller(this.player);
            List<ItemStack> itemsDropped = new ArrayList<>();
            long initialTime = System.nanoTime();
            this.server.getPluginManager().callEvent(new EntityDeathEvent((LivingEntity) mockEntity, itemsDropped));
            long finalTime = System.nanoTime()-initialTime;
            System.out.println(finalTime+" Nanoseconds");
            Assert.assertFalse(this.player.hasPotionEffect(PotionEffectType.REGENERATION));
    }
    @Test
    public void warriorEffectTestWrongHelmet(){
        this.server = MockBukkit.getOrCreateMock();
        this.curiousClasses = MockBukkit.load(CuriousClasses.class);
        this.player = this.server.addPlayer();
        this.server.getPluginManager().callEvent(new PlayerJoinEvent(this.player, Component.text("Test")));
        this.server.addSimpleWorld("test");
        WorldMock worldMock = (WorldMock) this.server.getWorlds().get(0);

        this.player.getWorld();
        LivingEntityMock mockEntity = (LivingEntityMock) worldMock.spawnEntity(new Location(worldMock,0,0,0), EntityType.SKELETON);
        mockEntity.setKiller(this.player);

        List<ItemStack> itemsDropped = new ArrayList<>();
        ItemStack itemStack = new ItemStack(Material.DIAMOND_HELMET);
        this.player.getInventory().setHelmet(itemStack);

        long initialTime = System.nanoTime();
        this.server.getPluginManager().callEvent(new EntityDeathEvent((LivingEntity) mockEntity, itemsDropped));
        long finalTime = System.nanoTime()-initialTime;

        System.out.println(finalTime+" Nanoseconds");
        Assert.assertFalse(this.player.hasPotionEffect(PotionEffectType.REGENERATION));
    }

}
