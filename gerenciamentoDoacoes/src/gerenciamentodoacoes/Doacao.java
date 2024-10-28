package gerenciamentodoacoes;

public class Doacao {
    private int id_doacao;
    private String rg;
    private String cnpj;
    private String cnpj_beneficiario;
    private String descricao;
    private String categoria;


    public Doacao(int id_doacao, String rg, String cnpj, String cnpj_beneficiario, String descricao, String categoria) {
        this.id_doacao = id_doacao;
        this.rg = rg;
        this.cnpj = cnpj;
        this.cnpj_beneficiario = cnpj_beneficiario;
        this.descricao = descricao;
        this.categoria = categoria;
    }
    
    public int getID_doacao() {
        return id_doacao;
    }
    
    public void setID_doacao(int id_doacao) {
        this.id_doacao = id_doacao;
    }
    
    public String getRG() {
        return rg;
    }

    public void setRG(String rg) {
        this.rg = rg;
    }
    
    public String getCNPJ() {
        return cnpj;
    }
    
    public void setCNPJ(String cnpj) {
        this.cnpj = cnpj;
    }

    
    public String getCNPJ_beneficiario() {
        return cnpj_beneficiario;
    }

    public void setCNPJ_beneficiario(String cnpj_beneficiario) {
        this.cnpj_beneficiario = cnpj_beneficiario;
    }
    
    public String getDescricao(){
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }   
}


