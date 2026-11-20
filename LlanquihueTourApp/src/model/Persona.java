package model;

import util.Validacion;

public class Persona {
    private String nombre;
    private String correo;
    private String telefono;
    private final Direccion direccion;

    public Persona(String nombre, String correo, String telefono, Direccion direccion) {
        setNombre(nombre);
        setCorreo(correo);
        setTelefono(telefono);
        if (direccion == null) {
            throw new IllegalArgumentException("La dirección es obligatoria.");
        }
        this.direccion = new Direccion(direccion.getCalle(), direccion.getNumero(), direccion.getComuna());
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = Validacion.requerido(nombre, "nombre"); }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = Validacion.correo(correo); }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = Validacion.telefono(telefono); }

    public Direccion getDireccion() {
        return new Direccion(direccion.getCalle(), direccion.getNumero(), direccion.getComuna());
    }

    public void setDireccion(Direccion nuevaDireccion) {
        if (nuevaDireccion == null) {
            throw new IllegalArgumentException("La dirección es obligatoria.");
        }
        direccion.setCalle(nuevaDireccion.getCalle());
        direccion.setNumero(nuevaDireccion.getNumero());
        direccion.setComuna(nuevaDireccion.getComuna());
    }

    @Override
    public String toString() {
        return nombre + " | " + correo + " | " + telefono + " | " + direccion;
    }
}
