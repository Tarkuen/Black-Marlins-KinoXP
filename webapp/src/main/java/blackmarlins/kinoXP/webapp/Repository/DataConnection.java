package blackmarlins.kinoXP.webapp.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnection {
    private String connection;

    private String cONN_String="jdbc:mysql://%s:%s/%s?user=%s&password=%s&useSSL=false";
    private final String endpoint_String = "";
    private String username= "";
    private String password = "";
    private String port = "";
    private String schema = "";


   private static DataConnection instance;

    private DataConnection() {

        connection= String.format(cONN_String,
                endpoint_String,
                port,
                schema,
                username,
                password);
    }

    public DataConnection getInstance() {
        if(instance==null){
            return instance = new DataConnection();
        }
        return instance;
    }


    public Connection getConn() throws SQLException {
        return DriverManager.getConnection(connection);
    }




}
