package blackmarlins.kinoXP.webapp.Repository;

import org.springframework.context.annotation.Bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnection {
    private static String connection;

    private String cONN_String="jdbc:mysql://%s:%s/%s?user=%s&password=%s&useSSL=false";
    private final String endpoint_String = "blackmarlins.ckervnrsg7db.eu-central-1.rds.amazonaws.com";
    private String username= "Admin";
    private String password = "adminadmin";
    private String port = "3306";
    private String schema = "blackmarlinsdb";


   private static DataConnection instance;

    private DataConnection() {
        connection = String.format(cONN_String,
                endpoint_String,
                port,
                schema,
                username,
                password);
    }

    public static DataConnection getInstance() {
        if(instance==null){
            return instance = new DataConnection();
        }
        return instance;
    }


    public Connection getConn() throws SQLException {
        return DriverManager.getConnection(connection);
    }




}
