package io.curiositycore.curiousclasses.database.sql;

import io.curiositycore.thecuriositycore.database.credentials.SqlSourceInit;
import org.bukkit.configuration.file.FileConfiguration;

/**
 * Mediator that utilises the configuration file of the plugin to get credentials required for connecting to the
 * SQL Database.
 */
public class ArchetypeDatabaseMediator extends SqlSourceInit {
    @Override
    protected String setHost(FileConfiguration fileConfiguration) {
        return null;
    }

    @Override
    protected int setPort(FileConfiguration fileConfiguration) {
        return 0;
    }

    @Override
    protected String setDatabase(FileConfiguration fileConfiguration) {
        return null;
    }

    @Override
    protected String setUsername(FileConfiguration fileConfiguration) {
        return null;
    }

    @Override
    protected String setPassword(FileConfiguration fileConfiguration) {
        return null;
    }
}
