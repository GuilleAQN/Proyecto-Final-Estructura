package Entidades;

public class Empleado {

    private String código;
    private String nombreCompleto;
    private String cédula;
    private String dirección;

    public Empleado() {
        this("N/A", "N/A", "N/A", "N/A");
    }

    public Empleado(String código, String nombreCompleto, String cédula, String dirección) {
        this.código = código;
        this.nombreCompleto = nombreCompleto;
        this.cédula = cédula;
        this.dirección = dirección;
    }


    public String getCódigo() {
        return código;
    }

    public void setCódigo(String código) {
        this.código = código;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCédula() {
        return cédula;
    }

    public void setCédula(String cédula) {
        this.cédula = cédula;
    }

    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }

    @Override
    public String toString() {
        return "Clases.Empleado" +
                "\nCódigo: " + código +
                "\nNombre Completo: " + nombreCompleto +
                "\nCédula: " + cédula +
                "\nDirección: " + dirección +
                "\nFecha de Inicio de Labores: ";
    }
}