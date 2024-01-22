package uz.najottalim;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseCon {
    private final String url = "jdbc:postgresql://localhost/";
    private final String user = "";
    private final String password = "";

    private static DatabaseCon databaseCon = null;

    private DatabaseCon(){}

    public static DatabaseCon getInstance(){
        if (databaseCon == null){
            databaseCon = new DatabaseCon();
        }
        return databaseCon;
    }

    public Connection connect(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
