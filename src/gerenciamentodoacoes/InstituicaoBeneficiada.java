package gerenciamentodoacoes;

public class InstituicaoBeneficiada {
    private String cnpj_beneficiario;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
 


    public InstituicaoBeneficiada(String cnpj_beneficiario, String nome, String endereco, String telefone, String email) {
        this.cnpj_beneficiario = cnpj_beneficiario;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    public String getCNPJ_beneficiario() {
        return cnpj_beneficiario;
    }

    public void setCNPJ_beneficiario(String cnpj_beneficiario) {
        this.cnpj_beneficiario = cnpj_beneficiario;
    }
    
    public String getNome(){
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.email = endereco;
    } 
    
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
     public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }  
}