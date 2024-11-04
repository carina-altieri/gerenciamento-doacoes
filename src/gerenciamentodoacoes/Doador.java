package gerenciamentodoacoes;

import java.util.ArrayList;

public class Doador {;
    private String rg;
    private String nomeDoador;
    private String telefoneDoador;
    private String emailDoador;
    private final ArrayList<Doacao> produtosDoacao;

    public Doador(String rg, String nomeDoador, String telefoneDoador, String emailDoador) {
        this.rg = rg;
        this.nomeDoador = nomeDoador;
        this.telefoneDoador = telefoneDoador;
        this.emailDoador = emailDoador;
        this.produtosDoacao = new ArrayList<>();
    }
    
    public void adicionarDoacao(Doacao doacao) {
        produtosDoacao.add(doacao);
    }
        
    public String getRG() {
        return rg;
    }

    public void setRG(String rg) {
        this.rg = rg;
    }
    
    public String getNomeDoador(){
        return nomeDoador;
    }
    public void setNomeDoador(String nomeDoador) {
        this.nomeDoador = nomeDoador;
    }
    
    public String getTelefoneDoador() {
        return telefoneDoador;
    }

    public void setTelefoneDoador(String telefoneDoador) {
        this.telefoneDoador = telefoneDoador;
    }
    
     public String getEmailDoador() {
        return emailDoador;
    }

    public void setEmailDoador(String emailDoador) {
        this.emailDoador = emailDoador;
    }  
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RG: ").append(rg)
                .append(", Nome do doador: ").append(nomeDoador)
                .append(", Telefone: ").append(telefoneDoador)
                .append(", Email: ").append(emailDoador)
                .append(", Produtos Doados:\n");
                for (Doacao doacao : produtosDoacao) {
                    sb.append(" - ").append(doacao).append("\n");
                }
                return sb.toString();
    }
}