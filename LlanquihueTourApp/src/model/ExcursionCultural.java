package model;

public class ExcursionCultural extends ServicioTuristico {
    private final String lugarHistorico;

    public ExcursionCultural(String nombre, double duracionHoras, String lugarHistorico) {
        super(nombre, duracionHoras);
        this.lugarHistorico = lugarHistorico;
    }

    @Override
    public String toString() {
        return "Excursión cultural: " + super.toString()
                + " | Lugar histórico: " + lugarHistorico;
    }
}
