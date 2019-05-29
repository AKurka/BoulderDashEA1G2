package model;

import contract.IDiamondQuery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DiamondQuery extends DBQuery implements IDiamondQuery {

    public DiamondQuery(int level){
        super(level);
    }

    public ResultSet executeDiamondQuery(ResultSet result, Statement statement) throws SQLException {
        switch (level) {
            case 1:
                result = statement.executeQuery("call lvl1_diamonds()");
                break;
            case 2:
                result = statement.executeQuery("call lvl2_diamonds()");
                break;
            case 3:
                result = statement.executeQuery("call lvl3_diamonds()");
                break;
            case 4:
                result = statement.executeQuery("call lvl4_diamonds()");
                break;
            case 5:
                result = statement.executeQuery("call lvl5_diamonds()");
                break;
            default:
                System.out.print("SQL Diamond Error");
                break;
        }
        return result;
    }

    public void setQueryDiamond(ResultSet result){
        try{
            result.next();
            finalDiamonds = result.getInt(2);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
