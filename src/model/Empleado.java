package model;

public class Empleado extends Persona {
    private String cargo;

    public Empleado(String nombre, String correo, String telefono,
                    Direccion direccion, String cargo) {
        super(nombre, correo, telefono, direccion);
        this.cargo = cargo;
    }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    @Override
    public String toString() {
        return super.toString() + " | Cargo: " + cargo;
    }
}
