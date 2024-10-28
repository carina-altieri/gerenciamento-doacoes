package gerenciamentodoacoes;

import Connections.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RastreioDAO {
 
        public void create(Rastreio rastreio){        
        String query = "INSERT INTO rastreio (status) VALUES(?)";
        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
        ) {
            stmt.setString(1, rastreio.getStatus());
   
        } catch (SQLException e) {
            // Lança uma exceção em caso de erro.
            throw new RuntimeException(e);
        
        }
    }
    
        public List<Rastreio> readAll() {
        List<Rastreio> rastreios = new ArrayList<>();
        String query = "SELECT * FROM rastreio";
        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                rastreios.add(new Rastreio(rs.getInt("id_rastreio"), rs.getInt("id_doacao"), rs.getString("status")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rastreios;
    }
    
    public void update(Rastreio rastreio, int id_rastreio) {
        String query = "UPDATE Rastreio SET status = ? WHERE id_rastreio  = ?";
        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setString(1, rastreio.getStatus());
            stmt.setInt(2, id_rastreio);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void delete(int id_rastreio) {
        String query = "DELETE FROM rastreio WHERE id_rastreio = ?";
        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setInt(1, id_rastreio);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
