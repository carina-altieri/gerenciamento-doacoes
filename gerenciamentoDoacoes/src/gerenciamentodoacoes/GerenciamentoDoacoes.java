package gerenciamentodoacoes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciamentoDoacoes {
    public static void main(String[] args) {
        List<Instituicao> instituicoes = new ArrayList<>();
        List<Doador> doadores = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcao_selecionada;

        do {
            System.out.println("=== Menu ===");
            System.out.println("1. Cadastrar Empresa");
            System.out.println("2. Listar Empresas");
            System.out.println("3. Cadastrar Doador");
            System.out.println("4. Listar Doadores");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao_selecionada = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao_selecionada) {
                case 1:
                    System.out.print("Informe o CNPJ da empresa: ");
                    String cnpj = scanner.nextLine();
                    System.out.print("Informe o nome da empresa: ");
                    String nome = scanner.nextLine();
                    instituicoes.add(new Instituicao(cnpj, nome));
                    System.out.println("Empresa cadastrada com sucesso!\n");
                    break;
                case 2:
                    System.out.println("Empresas cadastradas:");
                    for (Instituicao instituicao : instituicoes) {
                        System.out.println(instituicao);
                    }
                    System.out.println();
                    break;
                case 3:
                    if (instituicoes.isEmpty()) {
                        System.out.println("Nenhuma empresa cadastrada. Cadastre uma empresa primeiro.\n");
                        break;
                    }
                    
                    System.out.print("Informe o RG do doador: ");
                    String rg = scanner.nextLine();
                    System.out.print("Informe o nome do doador: ");
                    String nomeDoador = scanner.nextLine();
                    System.out.print("Informe o telefone do doador: ");
                    String telefone = scanner.nextLine();
                    System.out.print("Informe o email do doador: ");
                    String email = scanner.nextLine();
                    doadores.add(new Doador(rg, nomeDoador, telefone, email));
                    System.out.println("Doador cadastrado com sucesso!\n");
                    break;
                    
                case 4:
                    System.out.println("Doadores cadastrados:");
                    for (Doador doador : doadores) {
                        System.out.println(doador);
                    }
                    System.out.println();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.\n");
                    break;
            }
        } while (opcao_selecionada != 0);

        scanner.close();
    }
          
}
