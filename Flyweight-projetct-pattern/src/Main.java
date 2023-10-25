import java.util.HashMap;
import java.util.Map;

// Classe Flyweight: ConnectionFlyweight
class ConnectionFlyweight {
    //Essas Variáveis serão utilizadas para representar elementos essenciais em uma consulta com o BD
    private String databaseUrl;//String que irá conter a url de conexão com o banco de dados
    private String username;//String que irá conter o nome de usuário
    private String password;//String que irá conter a senha de usuário
    //password está como string para que permita senhas com multiracacteres(letras,acentos entre qualquer outro símbolo)
    public ConnectionFlyweight(String databaseUrl, String username, String password) {
        this.databaseUrl = databaseUrl;
        this.username = username;
        this.password = password;
        //Construtor responsável por inicializar as informações necessárias para simular a conexão com o BD
    }

    public void executeQuery(String query) {
        System.out.println("Executando consulta: " + query);
        System.out.println("Usando o Banco de dados: " + databaseUrl);
        System.out.println("Usuário: " + username);
        // Lógica de execução da Query no banco de dados
        //A execução do trecho acima sempre irá retonar o resultado da consulta(query), o nome do BD em uso(databaseUrl) e o usuário que está realizando as consultas(username)
    }
}

//Fábrica responsável por criar e gerenciar as instâncias da classe "ConnectionFlyweight"
//Toda essa classe abaixo irá gerenciar as instâncias de conexão de banco de dados
class ConnectionFlyweightFactory {
    private Map<String, ConnectionFlyweight> connections = new HashMap<>();

    public ConnectionFlyweight getConnection(String databaseUrl, String username, String password) {
        String key = databaseUrl + "-" + username;
        if (!connections.containsKey(key)) {
            connections.put(key, new ConnectionFlyweight(databaseUrl, username, password));
        }
        return connections.get(key);
    }
}
