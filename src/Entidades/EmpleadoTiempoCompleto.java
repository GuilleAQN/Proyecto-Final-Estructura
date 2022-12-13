package Entidades;

/**
 * SubClase de la Clase "Empleado", con los métodos de la superclase dirigidos para los datos de tipo Rol: Tiempo Completo.
 * @author: Omar Aquino y Leandro Gonzalez
 * @since: 04/12/2022
 */

// Interfaces importadas
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EmpleadoTiempoCompleto extends Empleado {

    public void ingresarEmpleadoTiempoCompleto(int codigo, String nombre, String apellido, String cedula, String direccion, int estado, double salarioBruto) throws SQLException {

        super.ingresarEmpleado(codigo,nombre,apellido,cedula,direccion,salarioBruto);

        String stmt = "UPDATE empleados SET rol =? ,estado = ? WHERE codigo_empleado = ?;";

        try {
            PreparedStatement ps = conexion.conectar().prepareStatement(stmt);
            ps.setString(1,"Tiempo Completo");
            ps.setInt(2,estado);

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
    }// Cierre de metodo

    public void editarEmpleadoTiempoCompleto(int codigo, String nombre, String apellido, String cedula, String direccion, int estado, double salarioBruto) throws SQLException {
        super.editarEmpleado(codigo,nombre,apellido,cedula,direccion,"Tiempo Completo",salarioBruto);

        String stmt = "UPDATE empleados SET rol = ? ,estado = ? WHERE codigo_empleado = ?;"; //ps prepared statement, sentencia de base de datos en el que se edita de la tabla empleados, el registro con el codigo introducido

        try {

            PreparedStatement ps = conexion.conectar().prepareStatement(stmt);
            ps.setString(1,"Tiempo Completo");
            ps.setInt(2,estado);
            ps.setInt(3,codigo);

            ps.executeUpdate();//se ejecuta la actualizacion en la base de datos
            ps.close();

        } catch(SQLException ex) {

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
    } // Cierre de metodo


    public static void main(String[] args) throws SQLException { // Prueba
        EmpleadoTiempoCompleto empleado = new EmpleadoTiempoCompleto();
//        empleado.ingresarEmpleado(12123,"Juan","Carrion","000000","Un lugar",15000);
        empleado.editarEmpleadoTiempoCompleto(12123,"Juan","Carrion","00","Un lu",1,10.00);
    }

}// Cierre de Clase