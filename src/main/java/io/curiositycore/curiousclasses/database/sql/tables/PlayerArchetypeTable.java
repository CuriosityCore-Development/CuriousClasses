package io.curiositycore.curiousclasses.database.sql.tables;

import io.curiositycore.thecuriositycore.database.mysql.queries.SqlDataTypes;
import io.curiositycore.thecuriositycore.database.mysql.table.BaseSqlTable;
import io.curiositycore.thecuriositycore.database.mysql.table.SqlColumn;
import javax.sql.DataSource;

/**
 * <p>Table responsible for the storing {@linkplain
 * io.curiositycore.curiousclasses.archetypes.archetype.PlayerArchetype Player Archetype} persistence data. This includes
 * their unique id, archetypeId and current progress towards their next upgrade, along with progress required to upgrade.
 * </p>
 * It should be of note that the archetypeId is further defined within the {@linkplain ArchetypeIdTable ArchetypeIdTable}.
 */
public class PlayerArchetypeTable extends BaseSqlTable {
    /**
     * Constructor which initialises the datasource and name of the table.
     * @param dataSourceForTable The datasource of the database the table resides.
     * @param tableName The name of the table.
     */
    public PlayerArchetypeTable(DataSource dataSourceForTable, String tableName) {
        super(dataSourceForTable, tableName);
    }

    @Override
    protected SqlColumn[] initColumns(boolean tableExistsInDatabase) {
        addColumnToTable("playerId", SqlDataTypes.SMALLINT,10000,tableExistsInDatabase);
        addColumnToTable("ArchetypeId",SqlDataTypes.SMALLINT,10000,tableExistsInDatabase);
        addColumnToTable("currentProgress",SqlDataTypes.SMALLINT,50000,tableExistsInDatabase);
        addColumnToTable("progressUntilUpgrade",SqlDataTypes.SMALLINT,50000,tableExistsInDatabase);
        return this.columnsInTable;
    }

    /**
     * Gets the playerId from the table's cache.
     * @param rowIndex The index of the row to retrieve the Id.
     * @return The player's unique Id, to be used in conjunction with the PlayerId table to retrieve the player's UUID.
     */
    public int getPlayerId(int rowIndex){
        Object playerIdObject = getRowBaseOnIndex(rowIndex).getRowData()[0];
        return getCastedValue(Integer.class,playerIdObject);
    }

    /**
     * Gets the ArchetypeId from the table's cache.
     * @param rowIndex The index of the row to retrieve the Id.
     * @return The Archetype's unique Id, to be used in conjunction with the ArchetypeId table to retrieve the
     * Archetype of this Player.
     */
    public int getArchetypeId(int rowIndex){
        Object playerIdObject = getRowBaseOnIndex(rowIndex).getRowData()[1];
        return getCastedValue(Integer.class,playerIdObject);
    }

    /**
     * Gets the current progress of the Player's Archetype towards a tier upgrade.
     * @param rowIndex The index of the row to retrieve the Archetype Progress.
     * @return The Player's Archetype progress.
     */
    public int getCurrentProgress(int rowIndex){
        Object playerIdObject = getRowBaseOnIndex(rowIndex).getRowData()[2];
        return getCastedValue(Integer.class,playerIdObject);
    }

    /**
     * Gets the amount of progress required by the Player to upgrade the Tier of their Archetype.
     * @param rowIndex The index of the row to retrieve the required progress.
     * @return The required progress.
     */
    public int getProgressUntilUpgrade(int rowIndex){
        Object playerIdObject = getRowBaseOnIndex(rowIndex).getRowData()[3];
        return getCastedValue(Integer.class,playerIdObject);
    }
}
