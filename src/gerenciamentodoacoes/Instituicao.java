package gerenciamentodoacoes;

public class Instituicao {
    private String cnpj_instituicao;
    private String nomeInstituicao;

    public Instituicao(String nomeInstituicao, String cnpj_instituicao) {
        this.cnpj_instituicao = cnpj_instituicao;
        this.nomeInstituicao = nomeInstituicao;
    }
    
    public String getCNPJ_instituicao() {
        return cnpj_instituicao;
    }

    public void setCNPJ_instituicao(String cnpj_instituicao) {
        this.cnpj_instituicao = cnpj_instituicao;
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
                "CNPJ: '" + cnpj_instituicao + '\'' +
                ", NomeInstituicao: '" + nomeInstituicao + '\'' +
                '}';
    }
}

