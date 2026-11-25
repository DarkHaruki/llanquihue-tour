package ui;

import data.GestorServicios;
import model.ServicioTuristico;

public class Main {
    public static void main(String[] args) {
        GestorServicios gestor = new GestorServicios();
        ServicioTuristico[] servicios = gestor.crearServiciosDePrueba();

        System.out.println("=== LLANQUIHUE TOUR | SERVICIOS TURÍSTICOS ===");
        for (ServicioTuristico servicio : servicios) {
            System.out.println(servicio.toString());
        }
    }
}
