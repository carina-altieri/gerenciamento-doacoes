package gerenciamentodoacoes;

public class Rastreio {
    private int id_rastreio;
    private int id_doacao;
    private String status;
 

    public Rastreio(int id_rastreio, int id_doacao, String status/*, String dateStatus*/) {
        this.id_rastreio = id_rastreio;
        this.id_doacao = id_doacao;
        this.status = status;
        //this.dateStatus = dateStatus;
    }
    
    
    public int getID_rastreio() {
        return id_rastreio;
    }
    
    public void setID_rastreio(int id_rastreio) {
        this.id_rastreio = id_rastreio;
    }
    
    public int getID_doacao(){
        return id_doacao;
    }
    
    public void setID_doacao(int id_doacao) {
        this.id_doacao = id_doacao;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    } 
    
//    public String getDateStatus() {
//        return dateStatus;
//    }
//    
//    public void setDateStatus(String dateStatus) {
//        this.dateStatus = dateStatus;
//    }
}
