package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import model.Direccion;
import model.Empleado;
import service.RegistroPersonas;

public class LectorPersonas {
    private static final String ENCABEZADO = "nombre;correo;telefono;calle;numero;comuna;categoria";

    public RegistroPersonas cargar(Path archivo, PrintStream avisos) throws IOException {
        RegistroPersonas registro = new RegistroPersonas();
        try (BufferedReader lector = Files.newBufferedReader(archivo, StandardCharsets.UTF_8)) {
            String encabezado = lector.readLine();
            if (encabezado == null || !ENCABEZADO.equals(encabezado.replace("\uFEFF", "").trim())) {
                throw new IOException("El encabezado debe ser " + ENCABEZADO);
            }

            int numeroLinea = 1;
            String linea;
            while ((linea = lector.readLine()) != null) {
                numeroLinea++;
                if (linea.trim().isEmpty()) {
                    continue;
                }

                try {
                    registro.agregar(leerPersona(linea));
                } catch (IllegalArgumentException error) {
                    avisos.println("Línea " + numeroLinea + " omitida: " + error.getMessage());
                }
            }
        }
        return registro;
    }

    private Empleado leerPersona(String linea) {
        String[] campos = linea.split(";", -1);
        if (campos.length != 7) {
            throw new IllegalArgumentException("Se esperan siete campos separados por punto y coma.");
        }

        Direccion direccion = new Direccion(campos[3], campos[4], campos[5]);
        return new Empleado(campos[0], campos[1], campos[2], direccion, campos[6]);
    }
}
