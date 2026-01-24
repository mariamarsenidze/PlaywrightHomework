package ge.tbc.testautomation.data;

import java.sql.*;

public class DatabaseSteps {
    public ResultSet getAllRegistrationData() throws SQLException {
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=Registration;user=Real_User;password=RealUser123#;encrypt=false;";
        Connection con = DriverManager.getConnection(connectionUrl);
        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        return stmt.executeQuery("SELECT * FROM RegistrationData");
    }
}