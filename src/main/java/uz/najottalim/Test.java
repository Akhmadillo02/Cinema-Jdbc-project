package uz.najottalim;

import java.sql.Connection;

public class Test {
    public static void main(String[] args) {
        DatabaseCon databaseCon = DatabaseCon.getInstance();

        Connection connect = databaseCon.connect();

    }
}
