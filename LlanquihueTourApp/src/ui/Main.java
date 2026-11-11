package ui;

import data.GestorDatos;
import model.Tour;
import java.io.IOException;
import java.util.ArrayList;

/** Ejecuta la carga, el recorrido, el filtrado y la búsqueda del catálogo. */
public class Main {
    public static void main(String[] args) {
        // La ruta opcional permite usar otro archivo desde la terminal.
        String ruta = args.length > 0 ? args[0] : "resources/tours.txt";
        GestorDatos gestor = new GestorDatos();
        try {
            ArrayList<Tour> tours = gestor.cargarTours(ruta);
            System.out.println("=== CATÁLOGO COMPLETO ===");
            for (Tour tour : tours) {
                System.out.println(tour);
            }
            System.out.println("Total de tours: " + tours.size());

            // Filtra por tipo y guarda los resultados en otra colección.
            ArrayList<Tour> gastronomicos = new ArrayList<>();
            for (Tour tour : tours) {
                if (tour.getTipo().equalsIgnoreCase("gastronómico")) {
                    gastronomicos.add(tour);
                }
            }
            System.out.println("\n=== TOURS GASTRONÓMICOS ===");
            for (Tour tour : gastronomicos) {
                System.out.println(tour);
            }
            System.out.println("Total filtrados: " + gastronomicos.size());

            // Busca un tour por su nombre y detiene el recorrido al encontrarlo.
            String nombreBuscado = "Ruta del Kuchen";
            Tour encontrado = null;
            for (Tour tour : tours) {
                if (tour.getNombre().equalsIgnoreCase(nombreBuscado)) {
                    encontrado = tour;
                    break;
                }
            }
            System.out.println("\n=== BÚSQUEDA POR NOMBRE ===");
            System.out.println("Nombre buscado: " + nombreBuscado);
            System.out.println(encontrado != null ? encontrado : "Tour no encontrado.");
        } catch (IOException e) {
            System.err.println("No se pudo cargar el catálogo: " + e.getMessage());
            System.err.println("Verifica el archivo y ejecuta desde LlanquihueTourApp.");
            System.exit(1);
        }
    }
}
