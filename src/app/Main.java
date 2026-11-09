package app;

import model.Direccion;
import model.Empleado;
import model.Persona;

public class Main {
    public static void main(String[] args) {
        Persona cliente = new Persona("Camila Perez", "camila@example.com",
                "+56 9 1111 2222", new Direccion("Los Notros", "120", "Llanquihue"));

        Empleado guia = new Empleado("Felipe Vargas", "felipe@example.com",
                "+56 9 3333 4444", new Direccion("Los Alerces", "245", "Puerto Varas"),
                "Guia turistico");

        Empleado coordinadora = new Empleado("Daniela Munoz", "daniela@example.com",
                "+56 9 5555 6666", new Direccion("Los Coigues", "80", "Frutillar"),
                "Coordinadora de tours");

        System.out.println("LLANQUIHUE TOUR");
        System.out.println("Registro de personas (datos de ejemplo)");
        System.out.println();
        System.out.println("CLIENTE");
        System.out.println(cliente.toString());
        System.out.println();
        System.out.println("EMPLEADOS");
        System.out.println(guia.toString());
        System.out.println(coordinadora.toString());

        cliente.setTelefono("+56 9 7777 8888");
        System.out.println();
        System.out.println("ACTUALIZACION DEL TELEFONO DEL CLIENTE");
        System.out.println(cliente.getNombre() + ": " + cliente.getTelefono());
    }
}
