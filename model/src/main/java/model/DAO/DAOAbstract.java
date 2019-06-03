package model.DAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;

/**
 * <h1>The Class AbstractDAO.</h1>
 *
 * @author Groupe2
 */

public class DAOAbstract {

    /**
     * Execute query.
     *
     * @param query
     *            the query
     * @return the result set
     */

    protected static ResultSet executeQuery(final String query) {
        return DAOConnector.getInstance().executeQuery(query);
    }

    /**
     * Execute update.
     *
     * @param query
     *            the query
     * @return the int
     */

    protected static int executeUpdate(final String query) {
        return DAOConnector.getInstance().executeUpdate(query);
    }

    /**
     * Prepare call.
     *
     * @param query
     *            the query
     * @return the callable statement
     */

    static CallableStatement prepareCall(final String query) {
        return DAOConnector.getInstance().prepareCall(query);
    }
}
