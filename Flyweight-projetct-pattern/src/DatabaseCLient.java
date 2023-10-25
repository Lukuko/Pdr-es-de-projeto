import java.text.DecimalFormat;
public class DatabaseCLient {
    //Classe "Cliente"
    //Essa classe é responsável por emular o retorno que uma consulta de bd retornaria
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.##");  // Duas casas decimais
        ConnectionFlyweightFactory factory = new ConnectionFlyweightFactory();
        long memoriaInicial = Runtime.getRuntime().freeMemory();
        // Realizar 500 requisições ao banco de dados
        for (int i = 0; i < 1000000; i++) {
            if (i % 5 == 0) {
                ConnectionFlyweight connection = factory.getConnection("jdbc:mysql://localhost:3306/mydb", "user1", "password1");
                connection.executeQuery("SELECT usuário FROM usertb WHERE user ='Davi'");
            } else if (i % 5 == 1) {
                ConnectionFlyweight connection = factory.getConnection("jdbc:mysql://localhost:3306/mydb", "user1", "password1");
                connection.executeQuery("SELECT produto FROM produtostb WHERE produto_name ='Doce de Leite'");
            } else if (i % 5 == 2) {
                ConnectionFlyweight connection = factory.getConnection("jdbc:mysql://localhost:3306/otherdb", "user1", "password1");
                connection.executeQuery("SELECT validade FROM produtostb WHERE produto_name ='Doce de Leite'");
            } else if (i % 5 == 3) {
                ConnectionFlyweight connection = factory.getConnection("jdbc:mysql://localhost:3306/mydb", "user1", "password1");
                connection.executeQuery("UPDATE produtostb SET HaveStock = 'N' WHERE produto_name = 'Doce de Leite'");
            } else {
                ConnectionFlyweight connection = factory.getConnection("jdbc:mysql://localhost:3306/mydb", "user2", "password2");
                connection.executeQuery("SELECT produto FROM produtostb WHERE produto_name = 'Doce de Leite'");
            }
        }
        // Obtenha a memória livre após as operações
        long memoriaFinal = Runtime.getRuntime().freeMemory();

        // Calcule a quantidade de memória usada
        long memoriaUsada = memoriaInicial - memoriaFinal;
        System.out.println("Quantidade de memória usada: " + df.format(memoriaUsada / (1024.0 * 1024.0)) + " mb");
    }

}

