package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PersonDAO {

    Connection conn;
    PreparedStatement pstm;

    public void insertPerson(PersonDTO pdto) {
        String sql = "insert into person (name_person, age_person) values (?,?)";

        conn = new ConnectionDAO().dbConnect();

        try {
            ptsm = conn.prepareStatement(sql);
            ptsm.setString(1, pdto.getName());
            ptsm.setInt(2, pdto.getAge());

            ptsm.execute();
            ptsm.close();

            System.out.println("Informações inseridas com sucesso");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "personDAO: " + e)
        }
    }
}