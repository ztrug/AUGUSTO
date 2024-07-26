package projeto;

// Classe que representa os proventos
public class Proventos {
    private float auxilio;
    private float valeTransporte;
    private float saude;
    private float alimentacao;

    // Construtor para inicializar os proventos
    public Proventos(float auxilio, float valeTransporte, float saude, float alimentacao) {
        this.auxilio = auxilio;
        this.valeTransporte = valeTransporte;
        this.saude = saude;
        this.alimentacao = alimentacao;
    }

    // Getters e Setters
    public float getAuxilio() {
        return auxilio;
    }

    public void setAuxilio(float auxilio) {
        this.auxilio = auxilio;
    }

    public float getValeTransporte() {
        return valeTransporte;
    }

    public void setValeTransporte(float valeTransporte) {
        this.valeTransporte = valeTransporte;
    }

    public float getSaude() {
        return saude;
    }

    public void setSaude(float saude) {
        this.saude = saude;
    }

    public float getAlimentacao() {
        return alimentacao;
    }

    public void setAlimentacao(float alimentacao) {
        this.alimentacao = alimentacao;
    }
}
