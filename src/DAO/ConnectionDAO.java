package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDAO {
    private static final String username = "root";

    private static final String password = "";

    private static final String url = "jdbc:mysql://localhost:3306/clientes";

    public static Connection connectSQL() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        //Cria conexão com banco de dados
        Connection conn = DriverManager.getConnection(url, username, password);

        return conn;
    }

    public static void main(String[] args) throws Exception {
        Connection conn = connectSQL();

        if (conn != null) {
            //já há uma conexão
            conn.close();
        }
    }
}