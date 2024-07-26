package projeto;

// Classe abstrata que representa um funcionário
public abstract class Funcionario {
    private String nome;
    private String cpf;
    private String rg;
    private double salarioBase;

    // Construtor para inicializar os atributos do funcionário
    public Funcionario(String nome, String cpf, String rg, double salarioBase) {
        if (nome == null || cpf == null || rg == null) {
            throw new IllegalArgumentException("Nome, CPF e RG não podem ser nulos.");
        }
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.salarioBase = salarioBase;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    // Método abstrato para calcular o salário, deve ser implementado pelas subclasses
    public abstract double calcularSalario();
}
