package JDBCTESTS;

import org.testng.annotations.Test;

import java.sql.*;

public class jdbc_example {


        String dbUrl = "jdbc:oracle:thin:@54.225.26.215" ;
        String dbUsername = "hr";
        String dbPassword = "hr";

        @Test
        public void test1() throws SQLException {
            Connection connection = DriverManager.getConnection(dbUrl,dbPassword,dbUsername);

            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

            // run query and get the result in resultset object

            ResultSet resultSet = statement.executeQuery("Select * from departments");
            //HOW TO FİND HOW MANY ROWS WE HAVE FOR THE QUERY
            // GO TO LAST ROW
            resultSet.last();
            // get the row count
            int rowCount = resultSet.getRow();
            System.out.println(rowCount);
            resultSet.beforeFirst();

            while (resultSet.next()){
                System.out.println(resultSet.getString(2));
            }
            resultSet = statement.executeQuery("Select * from regions");
            while (resultSet.next()){
                System.out.println(resultSet.getString(2));
            }


            //CLOSE ALL CONNECTİONS
            resultSet.close();
            statement.close();
            connection.close();


    }
}
