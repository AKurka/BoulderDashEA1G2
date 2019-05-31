package view.DAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;

public class DAOAbstract {


    protected static ResultSet executeQuery(final String query) {
        return DAOConnector.getInstance().executeQuery(query);
    }

    protected static int executeUpdate(final String query) {
        return DAOConnector.getInstance().executeUpdate(query);
    }

    static CallableStatement prepareCall(final String query) {
        return DAOConnector.getInstance().prepareCall(query);
    }
}
