package gerenciamentodoacoes;

public class Rastreio {
    private int idRastreio;
    private int idDoacao;
    private String status;
 
    public Rastreio(int idRastreio, int idDoacao, String status) {
        this.idRastreio = idRastreio;
        this.idDoacao = idDoacao;
        this.status = status;
    }
    
    public Rastreio(int idDoacao, String status) {
        this.idDoacao = idDoacao;
        this.status = status;
    }
    
    public int getIdRastreio() {
        return idRastreio;
    }
    
    public void setIdRastreio(int idRastreio) {
        this.idRastreio = idRastreio;
    }
    
    public int getIdDoacao(){
        return idDoacao;
    }
    
    public void setIdDoacao(int idDoacao) {
        this.idDoacao = idDoacao;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    } 

    public void atualizarStatus(String novoStatus) {
        this.status = novoStatus;
    }
    
    @Override
    public String toString() { 
        return "Status da doação: " + status;
    }
    
}
