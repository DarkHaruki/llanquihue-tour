package model;

import util.Validacion;

public class Direccion {
    private String calle;
    private String numero;
    private String comuna;

    public Direccion(String calle, String numero, String comuna) {
        setCalle(calle);
        setNumero(numero);
        setComuna(comuna);
    }

    public String getCalle() { return calle; }
    public void setCalle(String calle) { this.calle = Validacion.requerido(calle, "calle"); }
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = Validacion.requerido(numero, "número"); }
    public String getComuna() { return comuna; }
    public void setComuna(String comuna) { this.comuna = Validacion.requerido(comuna, "comuna"); }

    @Override
    public String toString() {
        return calle + " " + numero + ", " + comuna;
    }
}
