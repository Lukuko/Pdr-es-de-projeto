import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        // Configuração de conexão com o banco de dados
        String jdbcUrl = "jdbc:mysql://localhost:3306/mydb";
        String username = "user1";
        String password = "password1";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Consulta 1
            executeQuery(connection, "SELECT usuário FROM usertb WHERE user = 'Davi'");

            // Consulta 2
            executeQuery(connection, "SELECT produto FROM produtostb WHERE produto_name = 'Doce de Leite'");

            // Consulta 3
            executeQuery(connection, "SELECT validade FROM produtostb WHERE produto_name = 'Doce de Leite'");

            // Consulta 4
            executeUpdate(connection, "UPDATE produtostb SET HaveStock = 'N' WHERE produto_name = 'Doce de Leite'");

            // Consulta 5
            executeQuery(connection, "SELECT produto FROM produtostb WHERE produto_name = 'Doce de Leite'");

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void executeQuery(Connection connection, String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Processar o resultado aqui

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void executeUpdate(Connection connection, String query) {
        try {
            Statement statement = connection.createStatement();
            int rowsAffected = statement.executeUpdate(query);

            // Processar a quantidade de linhas afetadas aqui

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
