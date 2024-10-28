package gerenciamentodoacoes;

import Connections.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoacaoDAO {
        public void create(Doacao doacao){
        
        String query = "INSERT INTO doacao (cnpj, RG, cnpj_beneficiario, descricao, categoria) VALUES(?, ?, ?, ?, ?)";
        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
        ) {
            stmt.setInt(1, doacao.getID_doacao());
            stmt.setString(1, doacao.getCNPJ());
            stmt.setString(2, doacao.getRG());
            stmt.setString(3, doacao.getCNPJ_beneficiario());
            stmt.setString(4, doacao.getDescricao());
            stmt.setString(5, doacao.getCategoria());
            stmt.execute();
        } catch (SQLException e) {
            // Lança uma exceção em caso de erro.
            throw new RuntimeException(e);
        
        }
    }
    
        public List<Doacao> readAll() {
        List<Doacao> doacoes = new ArrayList<>();
        String query = "SELECT * FROM doacao";
        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                doacoes.add(new Doacao(rs.getInt("id_doacao"), rs.getString("RG"),rs.getString("cnpj"), rs.getString("cnpj_beneficiario"), rs.getString("descricao"), rs.getString("categoria")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return doacoes;
    }
    
    public void update(Doacao doacao, int id_doacao) {
        String query = "UPDATE Doacao SET categoria = ?, descricao = ? WHERE id_doacao  = ?";
        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setString(1, doacao.getCategoria());
            stmt.setString(2, doacao.getDescricao());
            stmt.setInt(3, doacao.getID_doacao());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void delete(int id_doacao) {
        String query = "DELETE FROM doacao WHERE id_doacao = ?";
        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setInt(1, id_doacao);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
