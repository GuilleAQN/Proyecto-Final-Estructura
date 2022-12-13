package Entidades;

/**
 * Clase con los métodos para manipular la tabla "Empleados" capaz de Introducir y Actualizar registros, además
 * de mostrar todos lo registros en la tabla.
 * @author: Omar Aquino y Leandro Gonzales
 * @since: 04/12/2022
 */

import ControlDeDatos.Conexion;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Empleado {
    Conexion conexion = new Conexion();

    /**
     * Metodo que introduce los datos de un nuevo empleado a la Base de Datos.
     * @param codigo El parámetro es el código único del Empleado
     * @param nombre El parámetro es el nombre/s del Empleado
     * @param apellido El parámetro es el apellido/s del Empleado
     * @param cedula El parámetro es la cédula del Empleado
     * @param direccion El parámetro es la dirección del Empleado
     * @param salarioBruto El parámetro es el salario bruto del Empleado
     */
    public int ingresarEmpleado(int codigo, String nombre, String apellido, String cedula, String direccion, double salarioBruto) throws SQLException {

        int resultado = 0;
        String stmt = "INSERT INTO empleados (codigo_empleado ,nombre ,apellido ,cedula ,direccion ,rol ,salario_bruto) VALUES(?,?,?,?,?,?,?,?);";

        try {
            PreparedStatement ps = conexion.conectar().prepareStatement(stmt);
            ps.setInt(1,codigo);
            ps.setString(2,nombre);
            ps.setString(3,apellido);
            ps.setString(4,cedula);
            ps.setString(5,direccion);
            ps.setString(6,"Medio Tiempo");
            ps.setDouble(8, salarioBruto);

            ps.executeUpdate();//se ejecuta la actualizacion en la base de datos

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

    public static void eliminarEmpleado(int codigo) {
        Conexion conexion = new Conexion();

        String stmt = "DELETE FROM empleados WHERE codigo = ?;"; //ps prepared statement, sentencia de base de datos en el que se elimina de la tabla empleados, el registro con el codigo introducido
        try {

            PreparedStatement ps = conexion.conectar().prepareStatement(stmt);
            ps.setInt(1, codigo);

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
    }


    public static void main(String[] args) throws SQLException { // Prueba
        Empleado empleado = new Empleado();
        empleado.ingresarEmpleado(12121,"Juan","Carrion","000000","Un lugar",17000);
    }
}// Cierre de Clase