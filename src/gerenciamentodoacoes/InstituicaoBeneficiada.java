package gerenciamentodoacoes;

public class InstituicaoBeneficiada {
    private String cnpj_beneficiario;
    private String nomeBeneficiario;
    private String enderecoBeneficiario;
    private String telefoneBeneficiario;
    private String emailBeneficiario;
 


    public InstituicaoBeneficiada(String cnpj_beneficiario, String nomeBeneficiario, String enderecoBeneficiario, String telefoneBeneficiario, String emailBeneficiario) {
        this.cnpj_beneficiario = cnpj_beneficiario;
        this.nomeBeneficiario = nomeBeneficiario;
        this.enderecoBeneficiario = enderecoBeneficiario;
        this.telefoneBeneficiario = telefoneBeneficiario;
        this.emailBeneficiario = emailBeneficiario;
    }

    public String getCNPJ_beneficiario() {
        return cnpj_beneficiario;
    }

    public void setCNPJ_beneficiario(String cnpj_beneficiario) {
        this.cnpj_beneficiario = cnpj_beneficiario;
    }
    
    public String getNomeBeneficiario(){
        return nomeBeneficiario;
    }
    public void setNomeBeneficiario(String nomeBeneficiario) {
        this.nomeBeneficiario = nomeBeneficiario;
    }
    
    public String getEnderecoBeneficiario() {
        return enderecoBeneficiario;
    }

    public void setEnderecoBeneficiario(String enderecoBeneficiario) {
        this.enderecoBeneficiario = enderecoBeneficiario;
    } 
    
    public String getTelefoneBeneficiario() {
        return telefoneBeneficiario;
    }

    public void setTelefoneBeneficiario(String telefoneBeneficiario) {
        this.telefoneBeneficiario = telefoneBeneficiario;
    }
    
     public String getEmailBeneficiario() {
        return emailBeneficiario;
    }

    public void setEmailBeneficiario(String emailBeneficiario) {
        this.emailBeneficiario = emailBeneficiario;
    }  
    
      @Override
    public String toString() {
        return "Nome: " + nomeBeneficiario + ", CNPJ: " + cnpj_beneficiario + ", Endereço: " + enderecoBeneficiario + ", Email: " + emailBeneficiario + ", Telefone: " + telefoneBeneficiario;
    }
}