public class MainClass {
    public static void main(String args[]) {
        System.out.println("Digite o nome da pessoa");
        String name = inFromUser.readLine();
        System.out.println("Digite a idade da pessoa");
        Int age = Integer.valueOf(inFromUser.readLine());

        PersonDTO pdto = new PersonDTO();
        pdto.setName(name);
        pdto.setAge(age);

        PersonDAO pdao = new PersonDAO();
        pdao.insertPerson(pdto);
    }
}