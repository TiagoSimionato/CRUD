import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import DAO.ClientDAO;
import DTO.ClientDTO;


public class MainClass {
    public static void main(String args[]) throws Exception {
        //buffer para leitura do teclado
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        String choice;
        do {
            System.out.println("Escolha a operação que deseja realizar");
            System.out.println("[CREATE, READ, UPDATE, DELETE, SAIR]");
            choice = inFromUser.readLine();

            switch (choice.toUpperCase()) {
                case "CREATE":
                    System.out.println("Digite o nome do cliente");
                    String name = inFromUser.readLine();
                    System.out.println("Digite a idade do cliente");
                    int age = Integer.valueOf(inFromUser.readLine());
                    System.out.println("Digite o email do cliente");
                    String email = inFromUser.readLine();
            
                    //Crio a DTO que será usada para inserção no banco
                    ClientDTO cdto = new ClientDTO();
                    cdto.setName(name);
                    cdto.setAge(age);
                    cdto.setEmail(email);
            
                    //DAO irá realizar a operação de inserir
                    ClientDAO cdao = new ClientDAO("clientes", "root", "");
                    cdao.insertClient(cdto);
                    break;
                case "READ":
                    cdao = new ClientDAO("clientes", "root", "");
                    ArrayList<ClientDTO> clients = cdao.selectClient();
                    queryPrint(clients);
                    break;
                case "UPDATE":
                    System.out.println("Atualize o nome do cliente");
                    name = inFromUser.readLine();
                    System.out.println("Atualize a idade do cliente");
                    age = Integer.valueOf(inFromUser.readLine());
                    System.out.println("Atualize o email do cliente");
                    email = inFromUser.readLine();
                    System.out.println("Informe o id do cliente que deve ser atualizado");
                    int id = Integer.valueOf(inFromUser.readLine());
            
                    //Crio a DTO que será usada para atualização do registro no banco
                    cdto = new ClientDTO();
                    cdto.setName(name);
                    cdto.setAge(age);
                    cdto.setEmail(email);
                    cdto.setId(id);
            
                    //DAO irá realizar a operação de atualização
                    cdao = new ClientDAO("clientes", "root", "");
                    cdao.updateClient(cdto);
                    break;
                case "DELETE":
                    System.out.println("Informe o id do cliente que deve ser deletado");
                    id = Integer.valueOf(inFromUser.readLine());

                    //Crio a DTO com o id do registro que será apagado
                    cdto = new ClientDTO();
                    cdto.setId(id);

                    //DAO do cliente apaga o registro
                    cdao = new ClientDAO("clientes", "root", "");
                    cdao.deleteById(id);
                    break;
            }
        } while (choice.toUpperCase().compareTo("SAIR") != 0);
    }

    private static void queryPrint(ArrayList<ClientDTO> cdto) {
        System.out.println("\nResultados Encontrados:\n");
        for (int i = 0; i < cdto.size(); i++) {
            System.out.println("Cliente:");
            System.out.println("Id:" +  cdto.get(i).getId());
            System.out.println("Nome:" +  cdto.get(i).getName());
            System.out.println("Idade:" + cdto.get(i).getAge());
            System.out.println("Email:" + cdto.get(i).getEmail() + "\n");
        }
    }
}