package model;

import contract.IDAOConnector;

import java.sql.*;

public class DAOConnector extends DBQuery implements IDAOConnector {
    private final String URL = "url";
    private final String user = "";
    private final String password = "";
    private Connection connection = null;
    private int choice = 0;

    public DAOConnector(int level){
        super(level);
    }

    public void connection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, user, password);
            statement = connection.createStatement();
        }
        catch (final ClassNotFoundException e){
            e.printStackTrace();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }


    public int getChoice(){
        return choice;
    }

    public Statement getStatement(){
        return statement;
    }

    public ResultSet getResult(){
        return result;
    }

}
