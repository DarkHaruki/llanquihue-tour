package ui;

import data.LectorPersonas;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import model.Empleado;
import service.RegistroPersonas;

public class RegistroMain {
    public static void main(String[] args) {
        String archivo = args.length == 0 ? "resources/personas.csv" : args[0];
        RegistroPersonas registro;
        try {
            registro = new LectorPersonas().cargar(Paths.get(archivo), System.err);
        } catch (IOException | IllegalArgumentException error) {
            System.err.println("No se pudo cargar " + archivo + ": " + error.getMessage());
            System.exit(1);
            return;
        }

        System.out.println("=== LLANQUIHUE TOUR | REGISTRO DE PERSONAS ===");
        System.out.println("Archivo cargado: " + archivo);
        mostrar(registro.listar());

        try (Scanner consola = new Scanner(System.in, "UTF-8")) {
            while (true) {
                String opcion = preguntar(consola, "\n1. Listar  2. Buscar por nombre  3. Filtrar por categoría  0. Salir");
                if (opcion == null || opcion.equals("0")) {
                    break;
                }

                try {
                    switch (opcion) {
                        case "1":
                            mostrar(registro.listar());
                            break;
                        case "2":
                            String nombre = preguntar(consola, "Nombre o parte del nombre:");
                            if (nombre != null) {
                                mostrar(registro.buscarPorNombre(nombre));
                            }
                            break;
                        case "3":
                            String categoria = preguntar(consola, "Categoría (Guía turístico, Operador local, Proveedor de transporte):");
                            if (categoria != null) {
                                mostrar(registro.filtrarPorCargo(categoria));
                            }
                            break;
                        default:
                            System.out.println("Ingresa una opción del menú.");
                    }
                } catch (IllegalArgumentException error) {
                    System.out.println(error.getMessage());
                }
            }
        }
    }

    private static String preguntar(Scanner consola, String mensaje) {
        System.out.println(mensaje);
        return consola.hasNextLine() ? consola.nextLine().trim() : null;
    }

    private static void mostrar(List<Empleado> personas) {
        for (Empleado persona : personas) {
            System.out.println(persona);
        }
        System.out.println("Total de registros: " + personas.size());
    }
}
