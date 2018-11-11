package Model;

import java.sql.*;

/**
 * Created by IntelliJ IDEA.<br/>
 * User: peter<br/>
 * Date: 10/11/2018<br/>
 * Time: 14:02<br/>
 * To change this template use File | Settings | File Templates.
 */
public class SingletonOldTimer {

    private static SingletonOldTimer instance = new SingletonOldTimer();
    private static final String URL = "jdbc:mysql://localhost:3306/old_timer";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private Connection connection;
   // private PreparedStatement selectAllMembers;

    private SingletonOldTimer() {
    }

    public static SingletonOldTimer getInstance() {
        return instance;

    }

    public void laadDataBase() {
        try {

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

//            selectAllMembers = connection.prepareStatement(
//                    "SELECT * FROM Members ORDER BY Name");
//
//            ResultSet resultSet = selectAllMembers.executeQuery();
//
//            ResultSetMetaData metaData = resultSet.getMetaData();
//            int numberOfColumns = metaData.getColumnCount();
//
//            for (int i = 1; i <= numberOfColumns; i++) {
//                System.out.printf("%-8s\t", metaData.getColumnName(i));
//            }
//            System.out.println();
//
//            // display query results
//            while (resultSet.next()) {
//                for (int i = 1; i <= numberOfColumns; i++) {
//                    System.out.printf("%-8s\t", resultSet.getObject(i));
//                }
//                System.out.println();
//            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.exit(1);
        }
    }



}



