package JDBCTESTS;

import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class listofmap_example {
    String dbUrl = "jdbc:oracle:thin:@54.225.26.215" ;
    String dbUsername = "hr";
    String dbPassword = "hr";


    @Test
public void MetaDataExample() throws SQLException {
    Connection connection = DriverManager.getConnection(dbUrl,dbPassword,dbUsername);

    Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
    ResultSet resultSet = statement.executeQuery("Select  first_name, last_name, salary, job_id from employees\n" +
            "where rownum<6");

// get the databese related data inside the dbmetadata object
    DatabaseMetaData dbMetedata = connection.getMetaData();

        ResultSetMetaData rsdm = resultSet.getMetaData();

        //list for keeping all rows a map
        List<Map<String, Object>> queryData = new ArrayList<>();
        // move to first row
        resultSet.next();
        Map<String, Object> row1 = new HashMap<>();
        row1.put(rsdm.getColumnName(1),resultSet.getString(1));
        row1.put(rsdm.getColumnName(2),resultSet.getString(2));
        row1.put(rsdm.getColumnName(3),resultSet.getString(3));
        row1.put(rsdm.getColumnName(4),resultSet.getString(4));
        System.out.println(row1.toString());
resultSet.next();
        Map<String, Object> row2 = new HashMap<>();
        row2.put(rsdm.getColumnName(1),resultSet.getString(1));
        row2.put(rsdm.getColumnName(2),resultSet.getString(2));
        row2.put(rsdm.getColumnName(3),resultSet.getString(3));
        row2.put(rsdm.getColumnName(4),resultSet.getString(4));
        System.out.println(row2.toString());

        queryData.add(row1);
        queryData.add(row2);
        System.out.println(queryData.get(0).get("last_name"));




















    //CLOSE ALL CONNECTİONS
    resultSet.close();
    statement.close();
    connection.close();


}
}
