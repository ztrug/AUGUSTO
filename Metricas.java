

package projeto;

// Classe que representa as métricas do funcionário
public class Metricas {
    private float hrs;
    private double ferias;
    private float quebraDeCaixa;
    private String licencas;

    // Construtor para inicializar as métricas
    public Metricas(float hrs, double ferias, float quebraDeCaixa, String licencas) {
        this.hrs = hrs;
        this.ferias = ferias;
        this.quebraDeCaixa = quebraDeCaixa;
        this.licencas = licencas;
    }

    // Getters e Setters
    public float getHrs() {
        return hrs;
    }

    public void setHrs(float hrs) {
        this.hrs = hrs;
    }

    public double getFerias() {
        return ferias;
    }

    public void setFerias(double ferias) {
        this.ferias = ferias;
    }

    public float getQuebraDeCaixa() {
        return quebraDeCaixa;
    }

    public void setQuebraDeCaixa(float quebraDeCaixa) {
        this.quebraDeCaixa = quebraDeCaixa;
    }

    public String getLicencas() {
        return licencas;
    }

    public void setLicencas(String licencas) {
        this.licencas = licencas;
    }
}