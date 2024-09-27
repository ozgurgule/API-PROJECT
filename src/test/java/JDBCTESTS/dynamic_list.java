package JDBCTESTS;
import org.testng.annotations.Test;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class dynamic_list {

    String dbUrl = "jdbc:oracle:thin:@54.225.26.215";
    String dbUsername = "hr";
    String dbPassword = "hr";

    @Test
    public void dynamic_list() throws SQLException {

        Connection connection = DriverManager.getConnection(dbUrl, dbPassword, dbUsername);

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("Select * from countries");

        // get the databese related data inside the dbmetadata object
        DatabaseMetaData dbMetedata = connection.getMetaData();

        ResultSetMetaData rsdm = resultSet.getMetaData();

        //list for keeping all rows a map
        List<Map<String, Object>> queryData = new ArrayList<>();


        int colCount = rsdm.getColumnCount();
        while (resultSet.next()) {
            Map<String, Object> row = new HashMap<>();

            for (int i = 1; i <=colCount; i++) {
                row.put(rsdm.getColumnName(i), resultSet.getObject(i));

            }
            queryData.add(row);
        }
        //print the result
        for (Map<String, Object> row : queryData) {
            System.out.println(row.toString());
        }





    //CLOSE ALL CONNECTİONS
    resultSet.close();
    statement.close();
    connection.close();


}
}

