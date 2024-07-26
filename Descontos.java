package projeto;

// Classe que representa os descontos aplicáveis
public class Descontos {
    private float inss;
    private float irrf;

    // Construtor para inicializar os descontos
    public Descontos(float inss, float irrf) {
        this.inss = inss;
        this.irrf = irrf;
    }

    // Getter e Setter para o INSS
    public float getInss() {
        return inss;
    }

    public void setInss(float inss) {
        this.inss = inss;
    }

    // Getter e Setter para o IRRF
    public float getIrrf() {
        return irrf;
    }

    public void setIrrf(float irrf) {
        this.irrf = irrf;
    }
}
