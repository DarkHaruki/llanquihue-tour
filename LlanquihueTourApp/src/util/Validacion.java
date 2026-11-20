package util;

import java.util.regex.Pattern;

public final class Validacion {
    private static final Pattern CORREO = Pattern.compile("[^\\s@]+@[^\\s@.]+(?:\\.[^\\s@.]+)+");
    private static final Pattern TELEFONO = Pattern.compile("\\+?[0-9]{8,15}");

    private Validacion() {
    }

    public static String requerido(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException("Completa el campo " + campo + ".");
        }
        return valor.trim();
    }

    public static String correo(String valor) {
        String correo = requerido(valor, "correo");
        if (!CORREO.matcher(correo).matches()) {
            throw new IllegalArgumentException("Correo inválido.");
        }
        return correo;
    }

    public static String telefono(String valor) {
        String telefono = requerido(valor, "teléfono");
        if (!TELEFONO.matcher(telefono.replace(" ", "").replace("-", "")).matches()) {
            throw new IllegalArgumentException("El teléfono debe tener entre 8 y 15 dígitos.");
        }
        return telefono;
    }
}
