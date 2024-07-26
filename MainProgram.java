package projeto;

import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sistema sistema = new Sistema();
        FolhaDePagamento folha = null;
        Empresas empresa = null;
        Usuario usuario1 = null;  // Mova a declaração para fora do switch

        System.out.println("*********************************************");
        System.out.println("* Bem-vindo ao Sistema de Folha de Pagamento *");
        System.out.println("*********************************************");

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Fazer Login");
            System.out.println("0 - Sair");

            int escolha = lerInteiro(scanner, "Escolha: ");

            switch (escolha) {
                case 1:
                    // Cadastro do usuário
                    usuario1 = cadastrarUsuario(scanner, sistema);

                    // Menu após cadastro do usuário
                    System.out.println("Cadastro do usuário concluído.");
                    while (true) {
                        System.out.println("Escolha uma opção:");
                        System.out.println("1 - Fazer Login");
                        System.out.println("0 - Sair");

                        int opcao = lerInteiro(scanner, "Escolha: ");
                        if (opcao == 1) {
                            // Fazer login após o cadastro
                            boolean autenticado = autenticarUsuario(scanner, sistema);
                            if (autenticado) {
                                // Cadastro da empresa
                                empresa = cadastrarEmpresa(scanner);

                                // Criação da folha de pagamento
                                folha = new FolhaDePagamento(empresa);

                                // Adicionar o usuário e os funcionários na folha
                                folha.adicionarUsuario(usuario1);

                                // Cadastro de funcionários CLT
                                System.out.println("Cadastro de funcionário CLT:");
                                FuncionarioCLT funcionarioCLT = cadastrarFuncionarioCLT(scanner);
                                folha.adicionarFuncionario(funcionarioCLT);

                                // Calcular e gerar a folha de pagamento do funcionário CLT
                                System.out.println("Gerando folha de pagamento para o funcionário CLT...");
                                folha.calcularFolha();

                                // Cadastro de funcionários PJ
                                System.out.println("Agora cadastre o funcionário PJ:");
                                FuncionarioPJ funcionarioPJ = cadastrarFuncionarioPJ(scanner);
                                folha.adicionarFuncionario(funcionarioPJ);

                                // Calcular e gerar a folha de pagamento completa
                                System.out.println("Gerando folha de pagamento para todos os funcionários...");
                                folha.calcularFolha();

                                System.out.println("Cadastro completo e folha de pagamento gerada.");
                            } else {
                                System.out.println("Não encontramos nenhuma conta para os dados fornecidos. Caso não tenha uma conta, clique 1 para cadastrar.");
                            }
                            break;
                        } else if (opcao == 0) {
                            System.out.println("Saindo do programa...");
                            scanner.close();
                            return; // Encerra o programa
                        } else {
                            System.out.println("Opção inválida. Tente novamente.");
                        }
                    }

                case 2:
                    // Verifica se o usuário foi cadastrado antes de tentar login
                    if (usuario1 == null) {
                        System.out.println("Nenhum usuário cadastrado. Primeiro, cadastre um usuário.");
                        break;
                    }

                    // Fazer login
                    boolean autenticado = autenticarUsuario(scanner, sistema);
                    if (autenticado) {
                        // Cadastro da empresa
                        empresa = cadastrarEmpresa(scanner);

                        // Criação da folha de pagamento
                        folha = new FolhaDePagamento(empresa);

                        // Adicionar o usuário e os funcionários na folha
                        folha.adicionarUsuario(usuario1);

                        // Cadastro de funcionários CLT
                        System.out.println("Cadastro de funcionário CLT:");
                        FuncionarioCLT funcionarioCLT = cadastrarFuncionarioCLT(scanner);
                        folha.adicionarFuncionario(funcionarioCLT);

                        // Calcular e gerar a folha de pagamento do funcionário CLT
                        System.out.println("Gerando folha de pagamento para o funcionário CLT...");
                        folha.calcularFolha();

                        // Cadastro de funcionários PJ
                        System.out.println("Agora cadastre o funcionário PJ:");
                        FuncionarioPJ funcionarioPJ = cadastrarFuncionarioPJ(scanner);
                        folha.adicionarFuncionario(funcionarioPJ);

                        // Calcular e gerar a folha de pagamento completa
                        System.out.println("Gerando folha de pagamento para todos os funcionários...");
                        folha.calcularFolha();

                        System.out.println("Cadastro completo e folha de pagamento gerada.");
                    } else {
                        System.out.println("Não encontramos nenhuma conta para os dados fornecidos. Caso não tenha uma conta, clique 1 para cadastrar.");
                    }
                    break;

                case 0:
                    System.out.println("Saindo do programa...");
                    scanner.close();
                    return; // Encerra o programa

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private static Usuario cadastrarUsuario(Scanner scanner, Sistema sistema) {
        String nome = lerString(scanner, "Digite seu nome: ");
        String cpf;
        String senha;

        while (true) {
            cpf = lerString(scanner, "Digite seu CPF (11 dígitos): ");

            if (cpf.length() != 11 || !cpf.matches("\\d+")) {
                System.out.println("O CPF deve ter exatamente 11 dígitos e conter apenas números.");
                continue;
            }

            senha = lerString(scanner, "Crie uma senha: ");

            try {
                sistema.cadastrar(nome, cpf, senha);
                return new Usuario(nome, cpf); // Sai do loop após cadastro bem-sucedido
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static Empresas cadastrarEmpresa(Scanner scanner) {
        String cnpj;
        while (true) {
            try {
                System.out.println("Cadastro da empresa:");
                System.out.print("Digite o nome da empresa: ");
                String nomeDaEmpresa = scanner.nextLine();
                System.out.print("Digite o CNPJ da empresa (14 dígitos): ");
                cnpj = scanner.nextLine().replaceAll("[^0-9]", "");

                if (cnpj.length() != 14) {
                    System.out.println("CNPJ inválido. Deve conter exatamente 14 dígitos. Tente novamente.");
                    continue;
                }

                System.out.print("Informe a porcentagem de INSS (0-100): ");
                float inss = Float.parseFloat(scanner.nextLine());
                System.out.print("Informe porcentagem de IRRF (0-100): ");
                float irrf = Float.parseFloat(scanner.nextLine());
                System.out.print("Informe o valor do vale transporte: ");
                float valeTransporte = Float.parseFloat(scanner.nextLine());
                System.out.print("Informe o valor do auxílio saúde: ");
                float saude = Float.parseFloat(scanner.nextLine());
                System.out.print("Informe o valor da alimentação: ");
                float alimentacao = Float.parseFloat(scanner.nextLine());
                System.out.print("Informe o valor do auxílio: ");
                float auxilio = Float.parseFloat(scanner.nextLine());

                Empresas empresa = new Empresas(nomeDaEmpresa, cnpj);
                empresa.setDescontos(new Descontos(inss, irrf));
                empresa.setProventos(new Proventos(valeTransporte, saude, alimentacao, auxilio));
                return empresa;
            } catch (Exception e) {
                System.out.println("Erro no cadastro da empresa. Verifique os dados e tente novamente.");
                scanner.nextLine(); // Limpar buffer
            }
        }
    }

    private static FuncionarioCLT cadastrarFuncionarioCLT(Scanner scanner) {
        System.out.print("Nome do funcionário CLT: ");
        String nome = scanner.nextLine();
        System.out.print("CPF do funcionário CLT: ");
        String cpf = scanner.nextLine();
        System.out.print("RG do funcionário CLT: ");
        String rg = scanner.nextLine();
        System.out.print("Salário base do funcionário CLT: ");
        double salarioBase = Double.parseDouble(scanner.nextLine());

        // Cadastro das métricas
        Metricas metricas = cadastrarMetricas(scanner);
        return new FuncionarioCLT(nome, cpf, rg, salarioBase, metricas);
    }

    private static FuncionarioPJ cadastrarFuncionarioPJ(Scanner scanner) {
        System.out.print("Nome do funcionário PJ: ");
        String nome = scanner.nextLine();
        System.out.print("CNPJ do funcionário PJ: ");
        String cpf = scanner.nextLine();
        System.out.print("RG do funcionário PJ: ");
        String rg = scanner.nextLine();
        System.out.print("Digite o total de horas trabalhadas do PJ: ");
        double horasTrabalhadas = Double.parseDouble(scanner.nextLine());
        System.out.print("Digite o valor da hora do PJ: ");
        double valorHora = Double.parseDouble(scanner.nextLine());

        // Cadastro das métricas
        return new FuncionarioPJ(nome, cpf, rg, horasTrabalhadas, valorHora);
    }

    private static Metricas cadastrarMetricas(Scanner scanner) {
        System.out.print("Digite as horas trabalhadas: ");
        float hrs = Float.parseFloat(scanner.nextLine());
        System.out.print("Digite o valor de férias: ");
        double ferias = Double.parseDouble(scanner.nextLine());
        System.out.print("Digite a quebra de caixa: ");
        float quebraDeCaixa = Float.parseFloat(scanner.nextLine());
        System.out.print("Digite as licenças: ");
        String licencas = scanner.nextLine();

        return new Metricas(hrs, ferias, quebraDeCaixa, licencas);
    }

    private static boolean autenticarUsuario(Scanner scanner, Sistema sistema) {
        boolean autenticado = false;
        while (!autenticado) {
            try {
                String cpf;
                do {
                    System.out.print("Para fazer seu Login:\nDigite seu CPF (11 dígitos): ");
                    cpf = scanner.nextLine();
                } while (cpf.length() != 11 || !cpf.matches("\\d+"));

                System.out.print("Digite a senha: ");
                String senha = scanner.nextLine();

                if (sistema.login(cpf, senha)) {
                    System.out.println("---------------------------");
                    System.out.println("Usuário autenticado com sucesso!");
                    autenticado = true;
                } else {
                    System.out.println("Login inválido.Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Erro durante a autenticação. Tente novamente.");
            }
        }
        return autenticado;
    }

    private static int lerInteiro(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número.");
            }
        }
    }

    private static String lerString(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
