package projeto;

// Classe que representa um funcionário CLT, herda de Funcionario
public class FuncionarioCLT extends Funcionario {
    private Metricas metricas;

    // Construtor para inicializar os atributos do funcionário CLT
    public FuncionarioCLT(String nome, String cpf, String rg, double salarioBase, Metricas metricas) {
        super(nome, cpf, rg, salarioBase); // Chamada ao construtor da classe base
        if (metricas == null) {
            throw new IllegalArgumentException("Métricas não podem ser nulas.");
        }
        this.metricas = metricas;
    }

    // Implementação do método abstrato para calcular o salário
    @Override
    public double calcularSalario() {
        // Lógica específica para cálculo de salário de funcionário CLT
        return getSalarioBase();
    }

    // Getter e Setter para métricas
    public Metricas getMetricas() {
        return metricas;
    }

    public void setMetricas(Metricas metricas) {
        this.metricas = metricas;
    }
}
