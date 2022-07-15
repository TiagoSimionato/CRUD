package DAO;

import DTO.ClientDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClientDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<ClientDTO> clientList = new ArrayList<ClientDTO>();

    //CREATE
    public void insertPerson(ClientDTO cdto) throws Exception {
        String sql = "insert into person (name, age, email) values (?,?,?)";

        try {
            //Criar conexão com banco de dados
            conn = ConnectionDAO.connectSQL();
            
            //Preparo a query
            pstm = conn.prepareStatement(sql);
            //Substituo '?' da string de preparo pelos valores corretos
            pstm.setString(1, cdto.getName());
            pstm.setInt(2, cdto.getAge());
            pstm.setString(3, cdto.getEmail());

            pstm.execute();
            pstm.close();

            conn.close();

            System.out.println("Informações inseridas com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //READ
    public ArrayList<ClientDTO> selectPerson(String columns) {
        String sql = "select " + columns + " from clients";

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                ClientDTO cdto = new ClientDTO();
                cdto.setId(rs.getInt("id"));
                cdto.setName(rs.getString("name"));
                cdto.setAge(rs.getInt("age"));
                cdto.setEmail(rs.getString("email"));

                clientList.add(cdto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return clientList;
    }

    public ArrayList<ClientDTO>  selectPerson() {
        return selectPerson("*");
    }

    //UPDATE
    public void update() {

    }
    //DELETE
    public void delete() {

    }
}