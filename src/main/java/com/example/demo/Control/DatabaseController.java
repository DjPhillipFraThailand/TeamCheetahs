package com.example.demo.Control;

import java.sql.*;

@SuppressWarnings("deprecation")
public class DatabaseController {
    public static Connection DBconnect;
    private static Statement statement;
    private static ResultSet resultSet;
<<<<<<< HEAD
    private static String DriverName = "com.mysql.cj.jdbc.Driver";
    private static String DBurl = "jdbc:mysql://localhost:3306/TeamCheetahs?serverTimezone=UTC?useSSL=false"; // ser det som én query? "serverTimezone=UTC?useSSL=false"
    private static String DBuser = "root";
    private static String DBpassword = "fedefrede1";
    public static String DBprefix = "Protocol_";
    private Connection connect = null;
//com.mysql.jdbc.Driver
    //com.mysql.cj.jdbc.Driver
//jdbc:mysql://localhost:3306/TeamCheetahs?serverTimezone=UTC?useSSL=false
    //jdbc:mysql://localhost:3306/TeamCheetahs?serverTimezone=UTC?


    private static String DriverName = "com.mysql.cj.jdbc.Driver";
    private static String DBdatabase = "sorom_dk_db2";
    private static String DBuser = "sorom_dk";
    private static String DBpassword = "09D30DBD26415BE6E9559863D9D";
    private static String DBurl = "jdbc:mysql://mysql29.unoeuro.com/"+DBdatabase+"?user="+DBuser+"&password="+DBpassword+"&useSSL=false&serverTimezone=UTC";
    public static String DBprefix = "AdventureXP_";

    // Database configuration start
    public DatabaseController() {
        try {
            Class.forName(DriverName).newInstance();

            //DBconnect = DriverManager.getConnection(DBurl, DBuser, DBpassword);
            DBconnect = DriverManager.getConnection(DBurl, DBuser, DBpassword);
            jdbc:mysql://localhost:3306/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
            //statement = DBconnect.createStatement();
            //connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/TeamCheetahs?serverTimezone=UTC?useSSL=false");
            //statement = connect.createStatement();

               DBurl = ""; DBuser = ""; DBpassword = "";
          //  connect = DriverManager.getConnection("jdbc:mysql://localhost/Ex1Person?user=root&password=fedefrede1");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Database configuration end

    // Outputs a query from a sql string
    public ResultSet dbQuery(String SQLstring) {
        try {
            resultSet = statement.executeQuery(SQLstring);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    // Performs a query from a sql string
    public void dbUpdate(String SQLstring) {
        try {
            statement.executeUpdate(SQLstring);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void statementUpdate(PreparedStatement preparedStatement) {
        try {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet statementQuery(PreparedStatement preparedStatement) {
        try {
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    // Returns the number of rows in a ResultSet
    public int resultCount(ResultSet set) throws SQLException {
        int rowCount;
        int currentRow = set.getRow();              // Get current row
        rowCount = set.last() ? set.getRow() : 0;   // Determine number of rows
        if (currentRow == 0) {                      // If there was no current row
            set.beforeFirst();                      // We want next() to go to first row
        } else {                                    // If there WAS a current row
            set.absolute(currentRow);               // Restore it
        }

        return rowCount;
    }

    // Securing a string before using in sql string
    public String res(String content) {
        try {
            content = content.replaceAll("\n","\\n")
                    .replaceAll("\r", "\\r")
                    .replaceAll("\t", "\\t")
                    .replaceAll("\00", "\\0")
                    .replaceAll("'", "\\'")
            /* replaceAll("\", "\\\\") */
            /*.replaceAll("\\"", "\\\"")*/;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return content;
    }
}