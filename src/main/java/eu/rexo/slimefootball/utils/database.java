package eu.rexo.slimefootball.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class database {
    private static Connection connection;
    private static final String dbhost = "localhost";
    private static final String dbport = "3306";
    private static final String dbdatabase = "java-learn";
    private static final String dbuser = "javalearn";
    private static final String dbpassword = "javalearn";

    public static Connection getConnection() throws Exception {
        if(connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection("jdbc:mysql://" + dbhost + ":" + dbport + "/" + dbdatabase + "?autoReconnect=true&useSSL=false", dbuser, dbpassword);
        }
        return connection;
    }

    public static Statement getStatement() {
        try {
            return getConnection().createStatement();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}