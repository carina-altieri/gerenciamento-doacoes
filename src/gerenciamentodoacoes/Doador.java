package gerenciamentodoacoes;

public class Doador {;
    private String rg;
    private String nome;
    private String telefone;
    private String email;

    public Doador(String rg, String nome, String telefone, String email) {
        this.rg = rg;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public String getRG() {
        return rg;
    }

    public void setRG(String rg) {
        this.rg = rg;
    }
    
    public String getNome(){
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
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
    
     @Override
    public String toString() {
        return "Doador{" +
                "RG:'" + rg + '\'' +
                ", Nome: '" + nome + '\'' +
                ", Telefone: '" + telefone + '\'' +
                ", Email:'" + email + '\'' +
                '}';
    }
}