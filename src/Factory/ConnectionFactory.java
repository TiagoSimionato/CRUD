package Factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    private static final String username = "root";

    private static final String password = "";

    private static final String url = "jdbc:mysql://localhost:3306/clientes?useSSL=false";

    public static Connection connectSQL() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        //Cria conexão com banco de dados
        Connection conn = DriverManager.getConnection(url, username, password);

        return conn;
    }
}