import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DecimalFormat;

public class DatabaseClient {
    public static void main(String[] args) {
        // Configuração de conexão com o banco de dados
        String jdbcUrl = "jdbc:mysql://localhost:3306/mydb";
        String username = "user1";
        String password = "password1";

        //Simulação de requisições ao BD
        for (int i = 0; i < 1000000; i++) {
            Connection connection = null;
            try {
                connection = DriverManager.getConnection(jdbcUrl, username, password);
                connection.close(); // Feche a conexão após a criação para simular o uso e fechamento.
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Mede a quantidade de memória usada
        long memoriaUsada = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        DecimalFormat df = new DecimalFormat("#.##"); // Duas casas decimais
        double memoriaUsadaMB = memoriaUsada / (1024.0 * 1024.0);

        System.out.println("Quantidade de memória usada: " + df.format(memoriaUsadaMB) + " MB");
    }
}
