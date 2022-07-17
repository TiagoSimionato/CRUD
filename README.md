# CRUD
 
 ## Software para gerenciar bancos de dados que estiverem na própria máquina. Para isso foram implementadas as operações básicas do CRUD.


 Para compilar, navegue até a pasta raiz do projeto e utilize os comandos:

    javac -d bin/ -cp ./src/:../resouces/mysql-connector-java-5.1.47.jar:. src/*.java

Depois, para compilar a GUI utilizeo comando:

    javac -d bin/ -cp ./src/:../resouces/mysql-connector-java-5.1.47.jar src/VIEW/ClientVIEW.java

Para executar a GUI, navegue até a pasta bin e utilize:

    java -cp .:../resouces/mysql-connector-java-5.1.47.jar VIEW.ClientVIEW 

Alternativamente para executar a classe e interagir por linha de comando use:

    java -cp .:../resouces/mysql-connector-java-5.1.47.jar MainClass


O gerenciador foi feito tendo como base um banco de clientes, mas é possível alterar o banco que se deseja gerenciar, bem como o usuário e a senha de quem irá realizar as alterações a partir dos inputs de texto que estão a direita na GUI.