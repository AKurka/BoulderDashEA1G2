package contract;

import java.sql.ResultSet;
import java.sql.Statement;

public interface IMapQuery {

    public ResultSet executeMapQuery(ResultSet result, Statement statement);

    public void setMapQuery(ResultSet result, char[][] tab);
}
