package projeto;

// Classe que representa um usuário
public class Usuario {
    private String cpf;
    private String senha;

    // Construtor para inicializar os atributos do usuário
    public Usuario(String cpf, String senha) {
        if (cpf == null || senha == null) {
            throw new IllegalArgumentException("CPF e senha não podem ser nulos.");
        }
        this.cpf = cpf;
        this.senha = senha;
    }

    // Getters e Setters
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
