package JDBCTESTS;

import java.sql.*;

public class main {
    public static void main(String[] args) throws SQLException {
        String dbUrl = "jdbc:oracle:thin:@18.234.138.186:1521:xe" ;
String dbUsername = "hr";
String dbPassword = "hr";
//create connection
        Connection connection = DriverManager.getConnection(dbUrl,dbPassword,dbUsername);

        Statement statement = connection.createStatement();

        // run query and get the result in resultset object

        ResultSet resultSet = statement.executeQuery("Select * from departments");

//        resultSet.next();
//        System.out.println(resultSet.getString("region_name"));
//        resultSet.next();
//        System.out.println(resultSet.getString(2));
//        //GETTING INFORMATION WITH COLUMN NAME
//
//
//        System.out.println(resultSet.getInt(1) + " - " + resultSet.getString("REGION_NAME"));
//        System.out.println(resultSet.getInt(2) + " - " + resultSet.getString("REGION_NAME"));

//        while (resultSet.next()){
//            System.out.println(resultSet.getInt(1) + " - " + resultSet.getString("region_name"));
//        }
//resultSet.next();
//        System.out.println( resultSet.getInt(1)+ "-" + resultSet.getString("region_name"));
//        resultSet.next();
//        System.out.println( resultSet.getInt(1)+ "-" + resultSet.getString("region_name"));
//        resultSet.next();
//        System.out.println( resultSet.getInt(1)+ "-" + resultSet.getString("region_name"));
//        resultSet.next();
//        System.out.println( resultSet.getInt(1)+ "-" + resultSet.getString("region_name"));
        while (resultSet.next()){
            System.out.println(resultSet.getString(1) +
                    " - "
                    + resultSet.getString(2) +
                    " - "
                    + resultSet.getString(3)+
                    " - "
                     + resultSet.getString(4));
        }
        //SQL is a program retrieve the data from database




//CLOSE ALL CONNECTİONS
        resultSet.close();
        statement.close();
        connection.close();

    }
}
