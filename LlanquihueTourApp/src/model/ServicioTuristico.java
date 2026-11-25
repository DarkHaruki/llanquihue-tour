package model;

public class ServicioTuristico {
    private final String nombre;
    private final double duracionHoras;

    public ServicioTuristico(String nombre, double duracionHoras) {
        this.nombre = nombre;
        this.duracionHoras = duracionHoras;
    }

    public String getNombre() {
        return nombre;
    }

    public double getDuracionHoras() {
        return duracionHoras;
    }

    @Override
    public String toString() {
        return nombre + " | Duración: " + duracionHoras + " h";
    }
}
