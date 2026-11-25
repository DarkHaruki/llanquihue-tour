package model;

public class PaseoLacustre extends ServicioTuristico {
    private final String tipoEmbarcacion;

    public PaseoLacustre(String nombre, double duracionHoras, String tipoEmbarcacion) {
        super(nombre, duracionHoras);
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    @Override
    public String toString() {
        return "Paseo lacustre: " + super.toString()
                + " | Embarcación: " + tipoEmbarcacion;
    }
}
