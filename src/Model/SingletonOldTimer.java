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

    public Connection laadDataBase() {
        try {

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return connection;

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.exit(1);
        }
        return null;
    }

    public void sluitDatabase() {

        try {
            connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

}




