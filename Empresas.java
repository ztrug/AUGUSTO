package projeto;

// Classe que representa uma empresa
public class Empresas {
    private String nomeDaEmpresa;
    private String cnpj;
    private Descontos descontos; // Associação com a classe Descontos
    private Proventos proventos; // Associação com a classe Proventos

    // Construtor para inicializar o nome e CNPJ da empresa
    public Empresas(String nomeDaEmpresa, String cnpj) {
        this.nomeDaEmpresa = nomeDaEmpresa;
        this.cnpj = cnpj;
    }

    // Getters e Setters
    public String getNomeDaEmpresa() {
        return nomeDaEmpresa;
    }

    public void setNomeDaEmpresa(String nomeDaEmpresa) {
        this.nomeDaEmpresa = nomeDaEmpresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Descontos getDescontos() {
        return descontos;
    }

    public void setDescontos(Descontos descontos) {
        this.descontos = descontos;
    }

    public Proventos getProventos() {
        return proventos;
    }

    public void setProventos(Proventos proventos) {
        this.proventos = proventos;
    }
}