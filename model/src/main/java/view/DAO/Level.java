package view.DAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Level extends DAOAbstract {

    private static String sqlExampleById   = "{call getLevel(?)}";


    public static String getLevel(final String name) throws SQLException {
        final CallableStatement callStatement = prepareCall(sqlExampleById);
        callStatement.setString(1, name);
        String level = "";
        if (callStatement.execute()) {
            final ResultSet result = callStatement.getResultSet();
            if (result.first()) {
                level = level+result.getString("level");
            }
            result.close();
        }
        return level;
    }
}