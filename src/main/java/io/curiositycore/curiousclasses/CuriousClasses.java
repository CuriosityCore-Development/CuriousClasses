package io.curiositycore.curiousclasses;

import io.curiositycore.curiousclasses.archetypes.managers.ArchetypeManager;
import io.curiositycore.curiousclasses.listeners.ListenerTest;
import org.bukkit.plugin.java.JavaPlugin;

public final class CuriousClasses extends JavaPlugin {
    ArchetypeManager archetypeManager = new ArchetypeManager();
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new ListenerTest(this.archetypeManager),this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
