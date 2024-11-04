package Connections;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    //Colocar o nome do banco de dados que você criou
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/gerenciamentoDoacoes";
    //Colocar o usuario que loga no MySQL Workbench
    private static final String USER = "root";
    //Colocar a senha que loga no MySQL Workbench
    private static final String PASSWORD = "senha";

    //Método que faz a conexão com o banco de dados
    public static Connection getConnection() {
        try {
            //Classe importada para usar o banco, sempre será usado no JAVA
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
