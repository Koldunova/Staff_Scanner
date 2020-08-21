package by.vitebsk.energo.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import by.vitebsk.energo.StaticData;

public class ConnectionDB {
    private String connectionString;
    private Connection connection;
    
    public ConnectionDB(String conString) {
        this.connectionString = conString;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(connectionString);
        } catch (ClassNotFoundException e) {
            StaticData.getLOGGER().writeLine(true, "ClassNotFoundException during reading config.xml (Class jdbc not found) - " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            StaticData.getLOGGER().writeLine(true, "SQLException during reading config.xml (Exception during connection) - " + e.getMessage());
            e.printStackTrace();
        }
        if (!StaticData.isExceptionExist()) {
            StaticData.getLOGGER().writeLine(false, "Succesful opening connection -- "+connectionString);
        }
    }
    
    public Connection getConnection() {
        return connection;
    }
    
    public void closeConnection() {
        try {
            connection.close();
            StaticData.getLOGGER().writeLine(false, "Connection close -- " + connectionString);
        } catch (SQLException e) {
            StaticData.getLOGGER().writeLine(true, "Exception while connection cloused -- " + e.getMessage());
            e.printStackTrace();
        }
    }

}
