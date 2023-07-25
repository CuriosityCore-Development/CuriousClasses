package io.curiositycore.curiousclasses.database.sql;

import io.curiositycore.curiousclasses.database.sql.tables.PlayerArchetypeTable;
import io.curiositycore.thecuriositycore.database.mysql.SqlTableManager;
import org.bukkit.configuration.file.FileConfiguration;

import java.sql.SQLException;

/**
 * Manager responsible for the registering, retrieval and manipulation of {@linkplain
 * io.curiositycore.curiousclasses.database.sql.tables SQL Tables} within the plugin.
 */
public class ArchetypeTableManager extends SqlTableManager {
    /**
     * Constructor which registers all initially applicable tables to the manager.
     * @param configFile The configuration file of the plugin that is responsible for SQL database credentials.
     * @throws SQLException Exception caused by a failed connection to the database.
     */
    public ArchetypeTableManager(FileConfiguration configFile) throws SQLException {
        ArchetypeDatabaseMediator archetypeDatabaseMediator = new ArchetypeDatabaseMediator();
        registerTable(new PlayerArchetypeTable(archetypeDatabaseMediator.getNewDataSource(configFile),
                "player_archetypes"));
    }
}
