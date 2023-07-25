package io.curiositycore.curiousclasses.database.sql.tables;

import io.curiositycore.thecuriositycore.database.mysql.table.BaseSqlTable;
import io.curiositycore.thecuriositycore.database.mysql.table.SqlColumn;

import javax.sql.DataSource;

/**
 * Table responsible for relating the ArchetypeId within the {@linkplain PlayerArchetypeTable} to the relevant
 * {@linkplain io.curiositycore.curiousclasses.archetypes.archetype.PlayerArchetype PlayerArchetype}.
 */
public class ArchetypeIdTable extends BaseSqlTable {
    /**
     * Constructor which initialises the datasource and name of the table.
     * @param dataSourceForTable The datasource of the database the table resides.
     * @param tableName The name of the table.
     */
    protected ArchetypeIdTable(DataSource dataSourceForTable, String tableName) {
        super(dataSourceForTable, tableName);
    }

    @Override
    protected SqlColumn[] initColumns(boolean b) {
        return new SqlColumn[0];
    }
}
