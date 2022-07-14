package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.swing.JOptionPane;

public class ConnectionDAO() {
    public Connection dbConnect() {
        Connection conn = null;

        try {
            String url = "jdbc:mysql://localhost:3306/*bancoaq*?use=root&password=";
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ConnectionDAO: " + e.getMessage());
        }  

        return conn;
    }
}