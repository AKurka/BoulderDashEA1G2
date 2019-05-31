package model.DAO;

import java.sql.*;

public class DAOConnector {

    private static DAOConnector instance;

    private static String user ="root";

    private static String password ="";

    private static String url = "";

    private Connection connection;

    private Statement statement;

    private DAOConnector(){
        this.open();
    }

    public static DAOConnector getInstance() {
        if (instance == null) {
            setInstance(new DAOConnector());
        }
        return instance;
    }

    private static void setInstance(final DAOConnector instance) {
        DAOConnector.instance = instance;
    }

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

    public ResultSet executeQuery(final String query) {
        try {
            return this.getStatement().executeQuery(query);
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public java.sql.CallableStatement prepareCall(final String query) {
        try {
            return this.getConnection().prepareCall(query);
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int executeUpdate(final String query) {
        try {
            return this.statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private Connection getConnection() {
        return this.connection;
    }

    public void setConnection(final Connection connection) {
        this.connection = connection;
    }

    private Statement getStatement() {
        return this.statement;
    }

    public void setStatement(final Statement statement) {
        this.statement = statement;
    }
}
