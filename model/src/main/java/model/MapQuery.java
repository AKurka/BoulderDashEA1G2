package model;

import contract.IMapQuery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MapQuery extends DBQuery implements IMapQuery {

    public MapQuery(int level){
        super(level);
    }

    public ResultSet executeMapQuery(ResultSet result, Statement statement){
        try {
            switch (level) {
                case 1:
                    result = statement.executeQuery("call `procedure_LV1`");
                    break;
                case 2:
                    result = statement.executeQuery("call `procedure_LV2`");
                    break;
                case 3:
                    result = statement.executeQuery("call `procedure_LV3`");

                    break;
                case 4:
                    result = statement.executeQuery("call `procedure_LV4`");
                    break;
                case 5:
                    result = statement.executeQuery("call `procedure_LV5`");
                    break;
                default:
                    System.out.print("System error");
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public void setMapQuery(ResultSet result, char[][] tab){
        try {
            int ligne = 0;
            while (result.next()) {
                for (int colonne = 0; colonne < result.getObject(2).toString().length(); colonne++) {
                    tab[ligne][colonne] = result.getObject(2).toString().charAt(colonne);
                }
                ligne++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}