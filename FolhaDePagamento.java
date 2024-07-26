package projeto;

import java.util.List;
import java.util.ArrayList;

// Classe que representa a folha de pagamento
public class FolhaDePagamento {
    private List<Funcionario> funcionarios; // Lista de funcionários
    private List<Usuario> usuarios; // Lista de usuários
    private Empresas empresa; // Associação com a classe Empresa

    // Construtor para inicializar a empresa e as listas
    public FolhaDePagamento(Empresas empresa) {
        this.empresa = empresa;
        this.funcionarios = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    // Método para adicionar um funcionário à lista
    public void adicionarFuncionario(Funcionario funcionario) {
        if (funcionario == null) {
            throw new IllegalArgumentException("Funcionário não pode ser nulo.");
        }
        this.funcionarios.add(funcionario);
    }

    // Método para adicionar um usuário à lista
    public void adicionarUsuario(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("Usuário não pode ser nulo.");
        }
        this.usuarios.add(usuario);
    }

    // Método para autenticar um usuário
    public boolean autenticarUsuario(String cpf, String senha) {
        if (cpf == null || senha == null) {
            return false;
        }
        for (Usuario usuario : usuarios) {
            if (usuario.getCpf().equals(cpf) && usuario.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }

    // Método para calcular a folha de pagamento
    public void calcularFolha() {
        if (empresa == null) {
            throw new IllegalStateException("Empresa não definida.");
        }
        System.out.println(" ");
        System.out.println("Folha de Pagamento");
        System.out.println("Empresa: " + empresa.getNomeDaEmpresa());
        System.out.println("CNPJ: " + empresa.getCnpj());
        for (Funcionario funcionario : funcionarios) {
            // Polimorfismo: chamada de método específico baseado no tipo de funcionário
            if (funcionario instanceof FuncionarioCLT) {
                calcularFolhaFuncionarioCLT((FuncionarioCLT) funcionario);
            } else if (funcionario instanceof FuncionarioPJ) {
                calcularFolhaFuncionarioPJ((FuncionarioPJ) funcionario);
            }
        }
    }

    // Método para calcular a folha de um funcionário CLT
    private void calcularFolhaFuncionarioCLT(FuncionarioCLT funcionario) {
        if (funcionario == null) {
            throw new IllegalArgumentException("Funcionário CLT não pode ser nulo.");
        }
        System.out.println("----------------------------");
        System.out.println("Nome: " + funcionario.getNome());
        System.out.println("CPF: " + funcionario.getCpf());
        System.out.println("RG: " + funcionario.getRg());
        System.out.println("Salário Base: " + funcionario.getSalarioBase());

        Metricas metricas = funcionario.getMetricas();
        if (metricas == null) {
            System.out.println("Erro: Métricas do funcionário são nulas.");
            return;
        }

        float salarioBase = (float) funcionario.getSalarioBase();
        float inss = salarioBase * empresa.getDescontos().getInss() / 100;
        float irrf = salarioBase * empresa.getDescontos().getIrrf() / 100;
        float valeTransporte = empresa.getProventos().getValeTransporte();
        float saude = empresa.getProventos().getSaude();
        float alimentacao = empresa.getProventos().getAlimentacao();

        float totalDescontos = inss + irrf + alimentacao;
        float totalProventos = empresa.getProventos().getAuxilio();

        float salarioLiquido = salarioBase - totalDescontos + totalProventos;

        System.out.println("Horas trabalhadas: " + metricas.getHrs());
        System.out.println("Férias: " + metricas.getFerias());
        System.out.println("Quebra de caixa: " + metricas.getQuebraDeCaixa());
        System.out.println("Licenças: " + metricas.getLicencas());

        System.out.println("INSS: " + inss);
        System.out.println("IRRF: " + irrf);
        System.out.println("Vale Transporte: " + valeTransporte);
        System.out.println("Saúde: " + saude);
        System.out.println("Alimentação: " + alimentacao);
        System.out.println("Total de Descontos: " + totalDescontos);
        System.out.println("Total de Proventos: " + totalProventos);
        System.out.println("Salário Líquido: " + salarioLiquido);
        System.out.println("Tipo de contrato: CLT");
    }

    // Método para calcular a folha de um funcionário PJ
    private void calcularFolhaFuncionarioPJ(FuncionarioPJ funcionario) {
        if (funcionario == null) {
            throw new IllegalArgumentException("Funcionário PJ não pode ser nulo.");
        }
        System.out.println("----------------------------");
        System.out.println("Nome: " + funcionario.getNome());
        System.out.println("CPF: " + funcionario.getCpf());
        System.out.println("RG: " + funcionario.getRg());
        System.out.println("Horas Trabalhadas: " + funcionario.getHorasTrabalhadas());
        System.out.println("Valor da Hora: " + funcionario.getValorHora());
        double salario = funcionario.calcularSalario(); // Correção: calculando o salário
        System.out.println("Salário: " + salario);
        System.out.println("Tipo de contrato: PJ");
    }
}
