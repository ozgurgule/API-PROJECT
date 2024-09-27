package JDBCTESTS;

import org.testng.annotations.Test;

import java.sql.*;

public class MetadataExample {     String dbUrl = "jdbc:oracle:thin:@54.225.26.215" ;
    String dbUsername = "hr";
    String dbPassword = "hr";

    @Test
    public void MetaDataExample() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl,dbPassword,dbUsername);

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("Select * from employees");

// get the databese related data inside the dbmetadata object
        DatabaseMetaData dbMetedata = connection.getMetaData();

        System.out.println("User = " + dbMetedata.getUserName());
        System.out.println("Database Product Name =" + dbMetedata.getDatabaseProductName());
        System.out.println("Database Product Version =  " + dbMetedata.getDatabaseProductVersion());
        System.out.println("Databese Driver Name = " + dbMetedata.getDriverName());
        System.out.println("Databese Driver Version =" + dbMetedata.getDriverVersion() );

        // get the resultset object metadata
        ResultSetMetaData rsdm = resultSet.getMetaData();
        int colCount = rsdm.getColumnCount();
        System.out.println(colCount);
        System.out.println(rsdm.getColumnCount());
        System.out.println(rsdm.getColumnName(1));
        System.out.println(rsdm.getColumnName(2));
        System.out.println(rsdm.getColumnName(3));
        // print all the column names dynamically
        for (int colIndex = 1; colIndex <= colCount; colIndex++) {
            System.out.print(rsdm.getColumnName(colIndex) + " - ");
            
        }



















        //CLOSE ALL CONNECTİONS
        resultSet.close();
        statement.close();
        connection.close();


    }
}
