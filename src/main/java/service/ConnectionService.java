package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionService {
    private static Connection connection;

    private ConnectionService() {}

    public static Connection makeConnection(String url, String username, String password) {
        if(connection == null){
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                connection = DriverManager.getConnection(url, username, password);
            } catch (ClassNotFoundException | SQLException e) {
                System.err.println("Failed to establish JDBC connection: " + e.getMessage());
                connection = null;
            }
        }
        return connection;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                connection = null;
            }
        } catch (SQLException e) {
            System.err.println("Failed to close JDBC connection: " + e.getMessage());
        }
    }
}
