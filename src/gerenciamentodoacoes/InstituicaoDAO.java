package gerenciamentodoacoes;

import Connections.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InstituicaoDAO {
     public void create(Instituicao instituicao){
        
        String query = "INSERT INTO instituição (nome, cnpj) VALUES(?, ?)";
        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
        ) {
            stmt.setString(1, instituicao.getNomeInstituicao());
            stmt.setString(2, instituicao.getCNPJinstituicao());
            stmt.execute();
        } catch (SQLException e) {
            // Lança uma exceção em caso de erro.
            throw new RuntimeException(e);
        
        }
    }
     
        public boolean exists(String nome) {
            String query = "SELECT * FROM instituição where nome = ?";
            try {
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, nome);
                ResultSet rs = stmt.executeQuery();
                return rs.next();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    
    public void update(Instituicao instituicao, int idInstituicao) {
        String query = "UPDATE instituição SET nome = ?, WHERE cnpj = ?";
        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setString(1,instituicao.getNomeInstituicao());
            stmt.setString(2, instituicao.getCNPJinstituicao());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void delete(int cnpj) {
        String query = "DELETE FROM instituição WHERE cnpj = ?";
        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setInt(1, cnpj);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
