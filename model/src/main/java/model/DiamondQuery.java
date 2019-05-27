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
                result = statement.executeQuery("call `GetDiamonds_1`()");
                break;
            case 2:
                result = statement.executeQuery("call `GetDiamonds_2`()");
                break;
            case 3:
                result = statement.executeQuery("call `GetDiamonds_3`()");
                break;
            case 4:
                result = statement.executeQuery("call `GetDiamonds_4`()");
                break;
            case 5:
                result = statement.executeQuery("call `GetDiamonds_5`()");
                break;
            default:
                System.out.print("System error");
                break;
        }
        return result;
    }

    public void setQueryDiamond(ResultSet result){
        try{
            result.next();
            finalDiamonds = result.getInt(1);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
