package ge.tbc.testautomation.data;

import org.testng.annotations.DataProvider;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegistrationData {
    @DataProvider(name = "registrationData")
    public Object[][] registrationDataProvider() throws SQLException {
        DatabaseSteps dbSteps = new DatabaseSteps();
        ResultSet rs = dbSteps.getAllRegistrationData();

        List<Object[]> data = new ArrayList<>();

        while (rs.next()) {
            data.add(new Object[]{
                    rs.getString("firstName"),
                    rs.getString("lastName"),
                    rs.getString("gender"),
                    rs.getString("model"),
                    rs.getString("address1"),
                    rs.getString("address2"),
                    rs.getString("city"),
                    rs.getString("contact1"),
                    rs.getString("contact2")
            });
        }

        return data.toArray(new Object[0][]);
    }

}
