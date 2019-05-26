package contract;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public interface IDiamondQuery {

    public ResultSet executeDiamondQuery(ResultSet result, Statement statement) throws SQLException;

    public void setQueryDiamond(ResultSet result);
}
