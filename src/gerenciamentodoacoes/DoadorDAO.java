package gerenciamentodoacoes;

import Connections.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoadorDAO {
 
        public void create(Doador doador){
        
        String query = "INSERT INTO doador (rg, nomeDoador, telefoneDoador, emailDoador) VALUES(?, ?, ?, ?)";
        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
        ) {
            stmt.setString(1, doador.getRG());
            stmt.setString(2, doador.getNomeDoador());
            stmt.setString(3, doador.getTelefoneDoador());
            stmt.setString(4, doador.getEmailDoador());
            stmt.execute();
        } catch (SQLException e) {
            // Lança uma exceção em caso de erro.
            throw new RuntimeException(e);
        
        }
    }
    
        public List<Doador> readAll() {
        List<Doador> doadores = new ArrayList<>();
        String query = "SELECT * FROM doador";
        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                doadores.add(new Doador(rs.getString("RG"), rs.getString("nome"), rs.getString("telefone"), rs.getString("email")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return doadores;
    }
    
    public void update(Doador doador, String rg) {
        String query = "UPDATE doador SET nomeDoador = ?, telefoneDoador = ?, emailDoador = ? WHERE RG = ?";
        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setString(1, doador.getRG());
            stmt.setString(2,doador.getNomeDoador());
            stmt.setString(3, doador.getTelefoneDoador());
            stmt.setString(4, doador.getEmailDoador());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void delete(String rg) {
        String query = "DELETE FROM doador WHERE RG = ?";
        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setString(1, rg);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
