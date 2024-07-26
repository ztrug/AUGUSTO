package projeto;

import java.util.HashMap;
import java.util.Map;

public class Sistema {
    private Map<String, Usuario> usuarios;

    public Sistema() {
        usuarios = new HashMap<>();
    }

    public void cadastrar(String nome, String cpf, String senha) {
        if (cpf.length() != 11) {
            throw new IllegalArgumentException("CPF inválido. Tente novamente!");
        }
        if (usuarios.containsKey(cpf)) {
            throw new IllegalArgumentException("Usuário já cadastrado.");
        }
        usuarios.put(cpf, new Usuario(cpf, senha)); // Adiciona senha ao instanciar o novo usuário
    }

    public boolean login(String cpf, String senha) {
        Usuario usuario = usuarios.get(cpf);
        return usuario != null && usuario.getSenha().equals(senha);
    }
}
