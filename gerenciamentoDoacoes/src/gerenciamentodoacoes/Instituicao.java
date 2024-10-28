package gerenciamentodoacoes;

public class Instituicao {
    private String cnpj;
    private String nome;

    public Instituicao(String nome, String cnpj) {
        this.cnpj = cnpj;
        this.nome = nome;
    }
    
    public String getCNPJ() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    } 
      
    public String getNome(){
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    @Override
     public String toString() {
        return "Empresa{" +
                "CNPJ: '" + cnpj + '\'' +
                ", Nome: '" + nome + '\'' +
                '}';
    }
}

