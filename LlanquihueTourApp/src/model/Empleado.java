package model;

import util.Validacion;

public class Empleado extends Persona {
    private String cargo;

    public Empleado(String nombre, String correo, String telefono, Direccion direccion, String cargo) {
        super(nombre, correo, telefono, direccion);
        setCargo(cargo);
    }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = Validacion.requerido(cargo, "categoría"); }

    @Override
    public String toString() {
        return super.toString() + " | " + cargo;
    }
}
