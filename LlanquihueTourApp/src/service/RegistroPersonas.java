package service;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import model.Empleado;
import util.Validacion;

public class RegistroPersonas {
    private final ArrayList<Empleado> personas = new ArrayList<>();
    private final Set<String> correos = new HashSet<>();

    public void agregar(Empleado persona) {
        Empleado copia = copiar(persona);
        if (!correos.add(copia.getCorreo().toLowerCase(Locale.ROOT))) {
            throw new IllegalArgumentException("Correo duplicado: " + copia.getCorreo());
        }
        personas.add(copia);
    }

    public ArrayList<Empleado> listar() {
        ArrayList<Empleado> resultado = new ArrayList<>();
        for (Empleado persona : personas) {
            resultado.add(copiar(persona));
        }
        return resultado;
    }

    public ArrayList<Empleado> buscarPorNombre(String nombre) {
        String consulta = normalizar(Validacion.requerido(nombre, "nombre"));
        ArrayList<Empleado> resultado = new ArrayList<>();
        for (Empleado persona : personas) {
            if (normalizar(persona.getNombre()).contains(consulta)) {
                resultado.add(copiar(persona));
            }
        }
        return resultado;
    }

    public ArrayList<Empleado> filtrarPorCargo(String cargo) {
        String consulta = normalizar(Validacion.requerido(cargo, "categoría"));
        ArrayList<Empleado> resultado = new ArrayList<>();
        for (Empleado persona : personas) {
            if (normalizar(persona.getCargo()).equals(consulta)) {
                resultado.add(copiar(persona));
            }
        }
        return resultado;
    }

    private String normalizar(String texto) {
        return Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "").toLowerCase(Locale.ROOT);
    }

    private Empleado copiar(Empleado persona) {
        return new Empleado(persona.getNombre(), persona.getCorreo(), persona.getTelefono(),
                persona.getDireccion(), persona.getCargo());
    }
}
