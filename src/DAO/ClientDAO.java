package DAO;

import DTO.ClientDTO;
import Factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ClientDAO {

    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;

    private final String username;
    private final String password;
    private final String dbName;

    public ClientDAO(String dbName, String username, String password) {
        this.dbName = dbName;
        this.username = username;
        this.password = password;
    }

    //CREATE
    //funcao create do crud. Recebe uma representação de um cliente e o insere no banco de dados
    public void insertClient(ClientDTO cdto) {
        //string base da declaração sql
        String sql = "insert into clients (name, age, email) values (?,?,?)";

        try {
            //Criar conexão com banco de dados
            conn = ConnectionFactory.connectSQL(dbName, username, password);
            
            //Preparo a query
            pstm = conn.prepareStatement(sql);
            //Substituo '?' da string de preparo pelos valores corretos
            pstm.setString(1, cdto.getName());
            pstm.setInt(2, cdto.getAge());
            pstm.setString(3, cdto.getEmail());

            //a declaração já está pronta, então já pode ser executada
            pstm.execute();

            System.out.println("Informações inseridas com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ClientDAO: " + e, "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            //por fim fechos conexões que estiverem abertas
            try {
                if (conn != null) {
                    conn.close();
                }
    
                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ClientDAO: " + e, "Erro", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }

    //READ
    //funcao read do crud. devolve todos os registros das colunas selecionadas da tabela de clientes
    public ArrayList<ClientDTO> selectClient(String columns) {
        //string base da declaração sql
        String sql = "select " + columns + " from clients";

        ArrayList<ClientDTO> clientList = new ArrayList<ClientDTO>();

        try {
            //inicio a conexão com o banco
            conn = ConnectionFactory.connectSQL(dbName, username, password);

            //preparo a query
            pstm = conn.prepareStatement(sql);
            //o resultado da busca ficara salvo no meu result set
            rs = pstm.executeQuery();

            //percorro os dados salvos no result set para transferir os dados para o array da classe DTO
            while (rs.next()) {
                ClientDTO cdto = new ClientDTO();
                cdto.setId(rs.getInt("id"));
                cdto.setName(rs.getString("name"));
                cdto.setAge(rs.getInt("age"));
                cdto.setEmail(rs.getString("email"));

                clientList.add(cdto);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ClientDAO: " + e, "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            //fecho conexões abertas
            try {
                if (conn != null) {
                    conn.close();
                }
    
                if (pstm != null) {
                    pstm.close();
                }
    
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ClientDAO: " + e, "Erro", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }

        return clientList;
    }

    //Se quiser todas as colunar da tabelas, é possivel chamar esse método
    public ArrayList<ClientDTO>  selectClient() {
        return selectClient("*");
    }

    //UPDATE
    //funcao de update do crud. Recebe a representação de cliente e usa o id armazenado nele para sobrescrever as outras informações
    public void updateClient(ClientDTO cdto) {
        //string base da declaração sql
        String sql = "update clients SET name = ?, age = ?, email = ? " +
        "WHERE id = ?";

        try {
            //inicio a conexão com o banco
            conn = ConnectionFactory.connectSQL(dbName, username, password);

            //preparo a query
            pstm = conn.prepareStatement(sql);
            //troco as '?' pelos valores que serão ajustados
            pstm.setString(1, cdto.getName());
            pstm.setInt(2, cdto.getAge());
            pstm.setString(3, cdto.getEmail());

            //id do registro que será alterado
            pstm.setInt(4, cdto.getId());

            //query pronta ja pode ser executada
            pstm.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ClientDAO: " + e, "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
    
                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ClientDAO: " + e, "Erro", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }

    //DELETE
    //funcao delete do crud. Recebe um id e o usará para deletar o registro desejado
    public void deleteById(int id) {
        //string base da declaração sql
        String sql = "delete from clients where id = ?";

        try {
            //inicio a conexão com o banco
            conn = ConnectionFactory.connectSQL(dbName, username, password);

            //preparo a query
            pstm = conn.prepareStatement(sql);
            //ajusto o paramatro do id
            pstm.setInt(1, id);

            //query esta pronta
            pstm.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ClientDAO: " + e, "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            //por fim fechos conexões que estiverem abertas
            try {
                if (conn != null) {
                    conn.close();
                }
    
                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ClientDAO: " + e, "Erro", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }
}