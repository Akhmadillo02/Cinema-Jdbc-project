package uz.najottalim;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseCon {
    private final String url = "jdbc:postgresql://localhost/postgres";
    private final String user = "postgres";
    private final String password = "Java0501";

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
