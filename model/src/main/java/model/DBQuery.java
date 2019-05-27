package model;

import contract.IDiamondQuery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBQuery {
    protected static int level = 0;
    protected static int finalDiamonds = 0;
    protected static char tab[][] = new char[15][15];
    protected static DAOConnector connectionDB;
    protected static MapQuery mapQuery;
    protected static Statement statement = null;
    protected static ResultSet result;
    protected static DiamondQuery diamondQuery;


    public DBQuery(int level){
        DBQuery.level = level;
    }

    public void Queries(){
        connectionDB = new DAOConnector(level);
        connectionDB.connection();

        mapQuery = new MapQuery(level);
        result = mapQuery.executeMapQuery(result, statement);

        diamondQuery = new DiamondQuery(level);
        try {
            result = diamondQuery.executeDiamondQuery(result, statement);
            diamondQuery.setQueryDiamond(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static char[][] getTab() {
        return tab;
    }

    public int getFinalDiamonds(){
        return finalDiamonds;
    }
}
