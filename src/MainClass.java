import java.io.BufferedReader;
import java.io.InputStreamReader;

import DAO.ClientDAO;
import DTO.ClientDTO;


public class MainClass {
    public static void main(String args[]) throws Exception {
        //buffer para leitura do teclado
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Digite o nome da pessoa");
        String name = inFromUser.readLine();
        System.out.println("Digite a idade da pessoa");
        int age = Integer.valueOf(inFromUser.readLine());

        ClientDTO pdto = new ClientDTO();
        pdto.setName(name);
        pdto.setAge(age);

        ClientDAO pdao = new ClientDAO();
        pdao.insertPerson(pdto);
    }
}