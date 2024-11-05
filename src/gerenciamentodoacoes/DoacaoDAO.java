package gerenciamentodoacoes;

import Connections.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoacaoDAO {
    public void create(Doacao doacao){
        
        String query = "INSERT INTO doacao (CNPJ_instituição, RG, CNPJ_beneficiario, descricao, categoria) VALUES(?, ?, ?, ?, ?)";
        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
        ) {
            stmt.setInt(1, doacao.getIdDoacao());
            stmt.setString(1, doacao.getCNPJinstituicao());
            stmt.setString(2, doacao.getRG());
            stmt.setString(3, doacao.getCNPJbeneficiario());
            stmt.setString(4, doacao.getDescricao());
            stmt.setString(5, doacao.getCategoria());
            stmt.execute();
        } catch (SQLException e) {
            // Lança uma exceção em caso de erro.
            throw new RuntimeException(e);
        
        }
    }
       
    public Doacao readOne(String rg) {
        String query = "SELECT * FROM doação where RG = ?";
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, rg);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                Doacao doacao = new Doacao(rs.getInt("id_doacao"), rs.getString("RG"), rs.getString("CNPJ_instituição"), rs.getString("CNPJ_beneficiário"), rs.getString("descricao"), rs.getString("categoria"));
                return doacao;
            }
        } catch (SQLException e) {
                throw new RuntimeException(e);
        }
        return null;
    }
    
    public void update(Doacao doacao, int idDoacao) {
        String query = "UPDATE Doacao SET categoria = ?, descricao = ? WHERE id_doacao  = ?";
        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setString(1, doacao.getCategoria());
            stmt.setString(2, doacao.getDescricao());
            stmt.setInt(3, doacao.getIdDoacao());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void delete(int idDoacao) {
        String query = "DELETE FROM doacao WHERE id_doacao = ?";
        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setInt(1, idDoacao);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
     public String getRastreioPorRG(String rg) {
        String sql = "SELECT d.descrição, r.status FROM doação d " +
                     "JOIN rastreio r ON d.id_doacao = r.id_doacao " +
                     "WHERE d.RG = ?";
        StringBuilder detalhesRastreio = new StringBuilder();

        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, rg);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String descricao = rs.getString("descricao");
                String status = rs.getString("status");
                detalhesRastreio.append("Doação: ").append(descricao)
                                 .append(" - Status: ").append(status)
                                 .append("\n");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar rastreamento por RG: " + e.getMessage(), e);
        }
        if (detalhesRastreio.length() == 0) {
            return "Nenhum rastreamento encontrado para o RG fornecido.";
        }
        return detalhesRastreio.toString();
    }
}
