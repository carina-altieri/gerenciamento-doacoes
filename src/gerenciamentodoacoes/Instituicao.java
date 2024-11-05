package gerenciamentodoacoes;

public class Instituicao {
    private String cnpjInstituicao;
    private String nomeInstituicao;

    public Instituicao(String nomeInstituicao, String cnpjInstituicao) {
        this.cnpjInstituicao = cnpjInstituicao;
        this.nomeInstituicao = nomeInstituicao;
    }
    
    public String getCNPJinstituicao() {
        return cnpjInstituicao;
    }

    public void setCNPJinstituicao(String cnpjInstituicao) {
        this.cnpjInstituicao = cnpjInstituicao;
    } 
      
    public String getNomeInstituicao(){
        return nomeInstituicao;
    }
    public void setNomeInstituicao(String nomeInstituicao) {
        this.nomeInstituicao = nomeInstituicao;
    }
    
    
    @Override
     public String toString() {
        return "Empresa{" +
                "CNPJ: '" + cnpjInstituicao + '\'' +
                ", NomeInstituicao: '" + nomeInstituicao + '\'' +
                '}';
    }
}

