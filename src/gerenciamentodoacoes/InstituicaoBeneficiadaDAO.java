package gerenciamentodoacoes;

import Connections.DatabaseConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstituicaoBeneficiadaDAO {
    
        public void create(InstituicaoBeneficiada instituicaoBeneficiada){
        
        String query = "INSERT INTO instituicao_beneficiada (cnpj_beneficiario, nome, endereco, telefone, email) VALUES(?, ?, ?, ?)";
        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
        ) { 
            stmt.setString(1, instituicaoBeneficiada.getCNPJ_beneficiario());
            stmt.setString(2, instituicaoBeneficiada.getNome());
            stmt.setString(3, instituicaoBeneficiada.getEndereco());
            stmt.setString(4, instituicaoBeneficiada.getTelefone());
            stmt.setString(5, instituicaoBeneficiada.getEmail());
            stmt.execute();
        } catch (SQLException e) {
            // Lança uma exceção em caso de erro.
            throw new RuntimeException(e);
        
        }
    }
    
        public List<InstituicaoBeneficiada> readAll() {
        List<InstituicaoBeneficiada> instituicoesBeneficiadas = new ArrayList<>();
        String query = "SELECT * FROM instituicao_beneficiada";
        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                instituicoesBeneficiadas.add(new InstituicaoBeneficiada(rs.getString("cnpj_beneficiario"),rs.getString("nome"), rs.getString("endereco"), rs.getString("telefone"), rs.getString("email")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return instituicoesBeneficiadas;
    }
    
    public void update(InstituicaoBeneficiada instituicaoBeneficiada, String cnpj_beneficiario) {
        String query = "UPDATE InstituicaoBeneficiada SET nome = ?, endereco = ?, telefone = ? WHERE cnpj_beneficiario  = ?";
        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setString(1,instituicaoBeneficiada.getNome());
            stmt.setString(2, instituicaoBeneficiada.getEndereco());
            stmt.setString(3, instituicaoBeneficiada.getTelefone());
            stmt.setString(3, instituicaoBeneficiada.getCNPJ_beneficiario());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void delete(int idBeneficiario) {
        String query = "DELETE FROM instituicao_beneficiaria WHERE id_beneficiario = ?";
        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setInt(1, idBeneficiario);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
