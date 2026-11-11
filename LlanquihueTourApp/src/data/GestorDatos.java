package data;

import model.Tour;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/** Lee el archivo de texto y transforma sus registros en objetos Tour. */
public class GestorDatos {
    public ArrayList<Tour> cargarTours(String ruta) throws IOException {
        ArrayList<Tour> tours = new ArrayList<>();
        // try-with-resources cierra el lector incluso si ocurre un error.
        try (BufferedReader lector = Files.newBufferedReader(
                Paths.get(ruta), StandardCharsets.UTF_8)) {
            String linea;
            int numeroLinea = 0;
            while ((linea = lector.readLine()) != null) {
                numeroLinea++;
                if (linea.trim().isEmpty()) { continue; }
                String[] campos = linea.split(";", -1);
                if (campos.length != 3 || campos[0].trim().isEmpty()
                        || campos[1].trim().isEmpty()) {
                    throw new IOException("Formato incorrecto en línea " + numeroLinea);
                }
                try {
                    int precio = Integer.parseInt(campos[2].trim());
                    if (precio < 0) { throw new NumberFormatException(); }
                    // Cada línea válida produce un objeto nuevo en la colección.
                    tours.add(new Tour(campos[0].trim(), campos[1].trim(), precio));
                } catch (NumberFormatException e) {
                    throw new IOException("Precio inválido en línea " + numeroLinea, e);
                }
            }
        }
        return tours;
    }
}
