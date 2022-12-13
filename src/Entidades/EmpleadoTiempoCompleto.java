package Entidades;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * SubClase de la Clase "Empleado", con los métodos de la superclase dirigidos para los datos de tipo Rol: Tiempo Completo.
 * @author: Omar Aquino y Leandro Gonzalez
 * @since: 04/12/2022
 */

public class EmpleadoTiempoCompleto extends Empleado {

    public int ingresarEmpleado(int codigo, String nombre, String apellido, String cedula, String direccion, int estado, double salarioBruto) throws SQLException {

        super.ingresarEmpleado(codigo,nombre,apellido,cedula,direccion,salarioBruto);
        int resultado = 0;

        String stmt = "INSERT INTO empleados (rol ,estado) VALUES(?,?);";

        try {
            PreparedStatement ps = conexion.conectar().prepareStatement(stmt);
            ps.setString(6,"Tiempo Completo");
            ps.setInt(7,estado);

            ps.executeUpdate();//Se ejecuta la actualizacion en la base de datos

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE,null,ex);

        } finally {
            try {
                if (conexion != null) {
                    conexion.conectar().close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
        return resultado;
    }// Cierre de metodo

    public static void main(String[] args) throws SQLException { // Prueba
        EmpleadoTiempoCompleto empleado = new EmpleadoTiempoCompleto();
        empleado.ingresarEmpleado(12122,"Juan","Carrion","000000","Un lugar",1,1);
    }

}// Cierre de Clase