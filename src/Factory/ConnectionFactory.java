package Factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    public static Connection connectSQL(String dbName, String username, String password) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false";

        //Cria conexão com banco de dados
        Connection conn = DriverManager.getConnection(url, username, password);

        return conn;
    }
}