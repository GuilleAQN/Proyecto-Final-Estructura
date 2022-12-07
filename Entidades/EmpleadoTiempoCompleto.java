package Entidades;

public class EmpleadoTiempoCompleto extends Empleado {

    private boolean activo;

    public EmpleadoTiempoCompleto() {
        this.activo = false;
    }

    public EmpleadoTiempoCompleto(String código, String nombreCompleto, String cédula, String dirección, boolean activo) {
        super(código, nombreCompleto, cédula, dirección);
        this.activo = activo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}