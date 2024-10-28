package gerenciamentodoacoes;

import Connections.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstituicaoDAO {
     public void create(Instituicao instituicao){
        
        String query = "INSERT INTO instituicao (nome, cnpj) VALUES(?, ?)";
        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
        ) {
            stmt.setString(1, instituicao.getCNPJ());
            stmt.setString(2, instituicao.getNome());
            stmt.execute();
        } catch (SQLException e) {
            // Lança uma exceção em caso de erro.
            throw new RuntimeException(e);
        
        }
    }
    
        public List<Instituicao> readAll() {
        List<Instituicao> instituicoes = new ArrayList<>();
        String query = "SELECT * FROM instituicao";
        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                instituicoes.add(new Instituicao(rs.getString("cnpj"), rs.getString("nome")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return instituicoes;
    }
    
    public void update(Instituicao instituicao, int idInstituicao) {
        String query = "UPDATE InstituicaoBeneficiada SET nome = ?, WHERE CNPJ  = ?";
        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setString(1,instituicao.getNome());
            stmt.setString(2, instituicao.getCNPJ());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void delete(int cnpj) {
        String query = "DELETE FROM instituicao WHERE cnpj = ?";
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
