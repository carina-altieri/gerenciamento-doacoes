package gerenciamentodoacoes;

//import java.util.ArrayList;
import java.util.Scanner;

public class GerenciamentoDoacoes {
//    private static final ArrayList<Doador> doadores = new ArrayList<>();
//    private static final ArrayList<Rastreio> rastreios = new ArrayList<>();
//    private static final ArrayList<InstituicaoBeneficiada> beneficiarios = new ArrayList<>();
    private static final InstituicaoDAO instituicaoDAO = new InstituicaoDAO();
    
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Scanner scanner = new Scanner(System.in)) {
            int opcao_selecionada;
            
            do {
                System.out.println("=== Menu ===");
                System.out.println("1. Cadastrar sua empresa");
                System.out.println("2. Cadastrar doador");
                System.out.println("3. Cadastrar doação para um doador existente");
                System.out.println("4. Cadastrar nova instituição beneficiada");
                System.out.println("5. Iniciar rastreio de doações");
                System.out.println("6. Atualizar status de rastreio");
                System.out.println("7. Listar empresas");
                System.out.println("8. Listar doadores");
                System.out.println("9. Listar instituições beneficiadas: ");
                System.out.println("0. Sair");
                System.out.print( "Selecione uma opção: ");
                opcao_selecionada = scanner.nextInt();
                scanner.nextLine();
                
                switch (opcao_selecionada) {
                    case 1 -> {
                        cadastrarInstituicao(scanner); 
                        break;
                    }
                    case 2 -> {   
                        if (!verificaInstituicao(scanner)) {
                            System.out.println("Empresa não cadastrada. Cadastre uma empresa primeiro.\n");
                            break;
                        }
//                        cadastrarDoador(scanner);
System.out.println("chamar cadastrarDoador");
                    }
//                    case 3 -> { 
//                        cadastrarDoacaoDoador(scanner);
//                        break;
//                    }
//                    case 4 -> { 
//                         cadastrarBeneficiario(scanner);
//                        break;
//                    }
//                    case 5 -> { 
//                         iniciarRastreio();
//                        break;
//                    }
//                    case 6 -> { 
//                         atualizarStatusRastreio(scanner);
//                        break;
//                    }
//                    case 7 -> { 
//                         listarEmpresas();
//                        break;
//                    }
//                    case 8 -> { 
//                         listarDoadores();
//                        break;
//                    }
//                    case 9 -> { 
//                         listarBeneficiarios();
//                        break;
//                    }
//                    case 0 -> { 
//                         System.out.println("Saindo...");
//                        break;
//                    }
                    default -> System.out.println("Opção inválida. Tente novamente.\n");
                }
                
            } while (opcao_selecionada != 0);
        }
    }


    private static void cadastrarInstituicao(Scanner scanner) {
        System.out.print("Informe o CNPJ da empresa: ");
        String cnpj_instituicao = scanner.nextLine();
        System.out.print("Informe o nome da empresa: ");
        String nomeInstituicao = scanner.nextLine();
        Instituicao instituicao = new Instituicao(nomeInstituicao, cnpj_instituicao);
        instituicaoDAO.create(instituicao);
        // To do: inserir no banco
        System.out.println("Empresa cadastrada com sucesso!\n");
    }

    private static boolean verificaInstituicao(Scanner scanner) {
        System.out.print("Insira o nome da sua empresa: ");
        String nomeInstituicao = scanner.nextLine();
        return instituicaoDAO.exists(nomeInstituicao);
    }
    
//    private static void cadastrarDoador(Scanner scanner) {
//       System.out.print("Informe o RG do doador: ");
//       String rg = scanner.nextLine();
//       System.out.print("Informe o nome do doador: ");
//       String nomeDoador = scanner.nextLine();
//       System.out.print("Informe o telefone do doador: ");
//       String telefoneDoador = scanner.nextLine();
//       System.out.print("Informe o email do doador: ");
//       String emailDoador = scanner.nextLine();
//       doadores.add(new Doador(rg, nomeDoador, telefoneDoador, emailDoador));
//       System.out.println("Doador cadastrado com sucesso!\n");
//    }
//   
//    private static void cadastrarDoacaoDoador(Scanner scanner) {
//       System.out.println("Informe o RG do doador para adicionar um produto: ");
//       String rg = scanner.nextLine();
//       Doador doador = encontrarDoador(rg);
//       if (doador == null) {
//           System.out.println("Doador não encontrado.");
//           return;
//        }
//       
//       System.out.print("Forneça uma descrição para o produto: ");
//       String descricao = scanner.nextLine();
//       System.out.println("Selecione uma categoria:");
//       System.out.println("1. Alimentos");
//       System.out.println("2. Vestuário");
//       System.out.println("3. Eletrônicos");
//       System.out.println("4. Móveis");
//       System.out.println("5. Outros");
//       System.out.print("Selecione uma opção: ");
//       int categoria_opcao = scanner.nextInt();
//       scanner.nextLine();
//                        
//        String categoria;
//        switch (categoria_opcao) {
//            case 1:
//                categoria = "Alimentos";
//                break;
//            case 2:
//                categoria = "Vestuário";
//                break;
//            case 3:
//                categoria = "Eletrônicos";
//                break;
//            case 4:
//                categoria = "Móveis";
//                break;
//            default:
//                categoria = "Outros";   
//            
//        }
//        
//        Doacao doacao = new Doacao(id_doacao, rg, cnpj_instituicao, cnpj_beneficiario, descricao, categoria);
//        doador.adicionarDoacao(doacao);
//        System.out.println("Doação do doador " + rg + " cadastrada com sucesso.");
//    }
//    
//    
//    private static void cadastrarBeneficiario(Scanner scanner) {
//        System.out.println("Informe o CNPJ da instituição beneficiada: ");
//        String cnpj_beneficiario = scanner.nextLine();
//        System.out.println("Informe o nome da instituição beneficiada: ");
//        String nomeBeneficiario = scanner.nextLine();
//        System.out.println("Informe o endereço da instituição beneficiada: ");
//        String enderecoBeneficiario = scanner.nextLine();
//        System.out.println("Informe o telefone da instituição beneficiada: ");
//        String telefoneBeneficiario = scanner.nextLine();
//        System.out.println("Informe o email da instituição beneficiada: ");
//        String emailBeneficiario = scanner.nextLine();
//        
//        InstituicaoBeneficiada instituicaoBeneficiada = new InstituicaoBeneficiada(cnpj_beneficiario, nomeBeneficiario, enderecoBeneficiario, telefoneBeneficiario, emailBeneficiario);
//        beneficiarios.add(instituicaoBeneficiada);
//        System.out.println("Beneficiário cadastrado com sucesso.");
//    }
//    
//    private static void iniciarRastreio() {
//        Rastreio rastreio = new Rastreio(id_rastreio, id_doacao, status);
//        rastreios.add(rastreio);
//        System.out.println("Rastreio iniciado. Status: Em preparo.");
//    }
//    
//    
//    private static void atualizarStatusRastreio(Scanner scanner) {
//        if (rastreios.isEmpty()) {
//            System.out.println("Nenhuma doação em rastreio.");
//        }
//    
//        System.out.println("Selecione o status atual:");
//        System.out.println("1. Em preparo");
//        System.out.println("2. Em transporte");
//        System.out.println("3. Entregue");
//        System.out.println("Opção: ");
//        int status_opcao = scanner.nextInt();
//        scanner.nextLine();
//        
//        String status = null;
//        switch (status_opcao) {
//            case 1: 
//                status = "Em preparo";
//                break;
//            case 2:
//                status = "Em transporte";
//                break;
//            case 3:
//                status = "Entregue";
//                break;
//            default:
//                System.out.println("Status inválido.");           
//        }
//        
//        for (Rastreio rastreio : rastreios) {
//            rastreio.atualizarStatus(status);
//        }
//        
//        System.out.println("Status atualizado para: " + status);
//    }
//    
//    private static void listarDoadores() {
//        System.out.println("Doadores e beneficiários: ");
//        for (Doador doador : doadores) {
//            System.out.println(doador);
//        }
//    }
//    
//    private static void listarBeneficiarios() {
//        System.out.println("Instituições beneficiadas: ");
//        for (InstituicaoBeneficiada instituicaoBeneficiada : beneficiarios) {
//            System.out.println(instituicaoBeneficiada);
//        }
//    }
//    
//    private static void listarEmpresas() {
//         System.out.println("Empresas cadastradas:");
//            for (Instituicao instituicao : instituicoes) {
//                System.out.println(instituicao);
//    }
//            
//    private static Doador encontrarDoador(String rg) {
//        for (Doador doador: doadores) {
//            if (doador.rg.equals(rg)) {
//                return doador;
//            }
//        }
//        return null; // retorna null se o doador não for encontrado
//    }
}
   