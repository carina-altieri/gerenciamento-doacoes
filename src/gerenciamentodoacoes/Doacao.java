package gerenciamentodoacoes;

public class Doacao {
    private int idDoacao;
    private String rg;
    private String cnpjInstituicao;
    private String cnpjBeneficiario;
    private String descricao;
    private String categoria;


    public Doacao(int idDoacao, String rg, String cnpjInstituicao, String cnpjBeneficiario, String descricao, String categoria) {
        this.idDoacao = idDoacao;
        this.rg = rg;
        this.cnpjBeneficiario = cnpjBeneficiario;
        this.cnpjInstituicao = cnpjInstituicao;
        this.descricao = descricao;
        this.categoria = categoria;
    }
    
    public Doacao(String rg, String cnpjInstituicao, String cnpjBeneficiario, String descricao, String categoria) {
        this.rg = rg;
        this.cnpjBeneficiario = cnpjBeneficiario;
        this.cnpjInstituicao = cnpjInstituicao;
        this.descricao = descricao;
        this.categoria = categoria;
    }
  
    public int getIdDoacao() {
        return idDoacao;
    }
    
    public void setIdDoacao(int idDoacao) {
        this.idDoacao = idDoacao;
    }
    
    public String getRG() {
        return rg;
    }

    public void setRG(String rg) {
        this.rg = rg;
    }
    
    public String getCNPJinstituicao() {
        return cnpjInstituicao;
    }
    
    public void setCNPJinstituicao(String cnpjInstituicao) {
        this.cnpjInstituicao = cnpjInstituicao;
    }

    public String getCNPJbeneficiario() {
        return cnpjBeneficiario;
    }

    public void setCNPJbeneficiario(String cnpjBeneficiario) {
        this.cnpjBeneficiario = cnpjBeneficiario;
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
    
    @Override
    public String toString() {
        return "Descrição: " + descricao + ", Categoria: " + categoria;
    }
}


