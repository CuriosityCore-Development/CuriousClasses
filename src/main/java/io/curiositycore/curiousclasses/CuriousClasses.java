package io.curiositycore.curiousclasses;

import io.curiositycore.curiousclasses.archetypes.managers.ArchetypeManager;
import io.curiositycore.curiousclasses.listeners.ListenerTest;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;


import java.io.File;

/**
 * The CuriousClasses plugin is [insert proxy description here]
 */
public class CuriousClasses extends JavaPlugin {
    private final boolean unitTest;
    public CuriousClasses(){
        super();
        unitTest = false;
    }
    @SuppressWarnings({"removal"})
    public CuriousClasses(PluginDescriptionFile description, File dataFolder, File file){
        super();
        unitTest = true;
    }
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
