package jm.task.core.jdbc.util;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/foo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "4891";

    public Connection getConnection(){
        Connection connection = null ;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
