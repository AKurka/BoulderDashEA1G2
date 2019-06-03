package model.DAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <h1>The Class Level.</h1>
 *
 * @author Groupe2
 */

public class Level extends DAOAbstract {

    /** The sql example by id. */

    private static String SQLRequest   = "{call getLevel(?)}";

    /**
     * Call the a statement which charge the level ask and return the correct level
     * @param name
     * 		Name of the level want to be call
     * @return level who was chose
     * @throws SQLException
     * 		throws a SQL Exception
     */

    public static String getLevel(final String name) throws SQLException {
        final CallableStatement callStatement = DAOAbstract.prepareCall(SQLRequest);
        callStatement.setString(1, name);
        String level = "";
        if (callStatement.execute()) {
            final ResultSet result = callStatement.getResultSet();
            if (result.first()) {
                level = level+result.getString("chars");
            }
            result.close();
        }
        return level;
    }
}