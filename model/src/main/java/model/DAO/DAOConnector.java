package model.DAO;

import java.sql.*;

/**
 * <h1>The Class DAOConnector.</h1>
 *
 * @author Groupe2
 */

public class DAOConnector {

    /** The instance. */
    private static DAOConnector instance;

    /**
     * The Login
     */

    private static String user ="root";

    /**
     * The password
     */

    private static String password ="";

    /**
     * The URL of the DB
     */

    private static String url = "jdbc:mysql://localhost/boulderdash?useSSL=false";


    /**
     * The Connection
     */
    private Connection connection;

    /**
     * The statement
     */
    private Statement statement;

    /**
     * Instantiate a new DB connection
     */

    private DAOConnector(){
        this.open();
    }

    /**
     * Gets the single instance of DAOConnector.
     *
     * @return single instance of DAOConnector
     */

    public static DAOConnector getInstance() {
        if (instance == null) {
            setInstance(new DAOConnector());
        }
        return instance;
    }

    /**
     * Sets the instance.
     *
     * @param instance
     *            the new instance
     */

    private static void setInstance(final DAOConnector instance) {
        DAOConnector.instance = instance;
    }


    /**
     * Open the connection
     *
     * @return true, if successful
     */
    private boolean open() {
        try {
            this.connection = DriverManager.getConnection(DAOConnector.url, DAOConnector.user, DAOConnector.password);
            this.statement = this.connection.createStatement();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Execute query.
     *
     * @param query
     *            the query
     * @return the result set
     */

    public ResultSet executeQuery(final String query) {
        try {
            return this.getStatement().executeQuery(query);
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Prepare call.
     *
     * @param query
     *            the query
     * @return the java.sql. callable statement
     */

    public java.sql.CallableStatement prepareCall(final String query) {
        try {
            return this.getConnection().prepareCall(query);
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Execute update.
     *
     * @param query
     *            the query
     * @return the int
     */

    public int executeUpdate(final String query) {
        try {
            return this.statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Gets the connection.
     *
     * @return the connection
     */

    private Connection getConnection() {
        return this.connection;
    }

    /**
     * Sets the connection.
     *
     * @param connection
     *            the new connection
     */

    public void setConnection(final Connection connection) {
        this.connection = connection;
    }

    /**
     * Gets the statement.
     *
     * @return the statement
     */

    private Statement getStatement() {
        return this.statement;
    }

    /**
     * Sets the statement.
     *
     * @param statement
     *            the new statement
     */

    public void setStatement(final Statement statement) {
        this.statement = statement;
    }
}
