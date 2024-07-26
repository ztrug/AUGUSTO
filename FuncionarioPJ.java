package projeto;

public class FuncionarioPJ extends Funcionario {
    private double horasTrabalhadas;
    private double valorHora;

    // Construtor corrigido
    public FuncionarioPJ(String nome, String cnpj, String rg, double horasTrabalhadas, double valorHora) {
        super(nome, cnpj, rg, 0);  // Passa 0 para salário base, que não é utilizado aqui
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHora = valorHora;
    }

    public double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(double horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    @Override
    public double calcularSalario() {
        return horasTrabalhadas * valorHora;
    }
}
