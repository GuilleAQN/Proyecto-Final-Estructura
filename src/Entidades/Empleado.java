package Entidades;

/**
 * Clase con los métodos para manipular la tabla "Empleados" capaz de Introducir y Actualizar registros, además
 * de mostrar todos lo registros en la tabla.
 * @author: Omar Aquino y Leandro Gonzalez
 * @since: 04/12/2022
 */

// Interfaces importadas
import ControlDeDatos.Conexion;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    public void ingresarEmpleado(int codigo, String nombre, String apellido, String cedula, String direccion, double salarioBruto) {

        String stmt = "INSERT INTO empleados (codigo_empleado ,nombre ,apellido ,cedula ,direccion ,rol ,salario_bruto) VALUES(?,?,?,?,?,?,?);";

        try {
            PreparedStatement ps = conexion.conectar().prepareStatement(stmt);
            ps.setInt(1,codigo);
            ps.setString(2,nombre);
            ps.setString(3,apellido);
            ps.setString(4,cedula);
            ps.setString(5,direccion);
            ps.setString(6,"Medio Tiempo");
            ps.setDouble(7, salarioBruto);

            ps.executeUpdate();//se ejecuta la actualizacion en la base de datos

            ps.close();

        } catch (SQLException ex) {
            System.out.println("Este cliente ya existe");

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


    /**
     * Metodo que eliminar un empleado a la Base de Datos.
     * @param codigo El parámetro es el código único del Empleado
     */
    public void eliminarEmpleado(int codigo) {
        String stmt = "DELETE FROM empleados WHERE codigo_empleado = ?;"; //ps prepared statement, sentencia de base de datos en el que se elimina de la tabla empleados, el registro con el codigo introducido

        try {
            PreparedStatement ps = conexion.conectar().prepareStatement(stmt); //conexion a la base de datos  y ejecucion de la sentencia sql
            ps.setInt(1, codigo); //posicion y el codigo del empleado que queremos localizar para posteriormente eliminarlo

            ps.executeUpdate();//se ejecuta la actualizacion en la base de datos
            ps.close(); // cierre de la conexion en la base de datos

        } catch(SQLException ex) {
            System.out.println("No existe un cliente un cliente");

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


    /**
     * Metodo que edita los datos de un empleado a la Base de Datos.
     * @param codigo El parámetro es el código único del Empleado
     * @param nombre El parámetro es el nombre/s del Empleado
     * @param apellido El parámetro es el apellido/s del Empleado
     * @param cedula El parámetro es la cédula del Empleado
     * @param direccion El parámetro es la dirección del Empleado
     * @param rol El parámetro es el rol que desempeña el empleado que puede ser: Medio Tiempo o Tiempo Completo
     * @param salarioBruto El parámetro es el salario bruto del Empleado
     */
    public void editarEmpleado(int codigo, String nombre, String apellido, String cedula, String direccion, String rol, double salarioBruto) {
        String stmt = "UPDATE empleados SET nombre = ?, apellido = ?, cedula = ?, direccion = ?, rol = ?, estado = ?,salario_bruto = ? WHERE codigo_empleado = ?;"; //ps prepared statement, sentencia de base de datos en el que se edita de la tabla empleados, el registro con el codigo introducido
        
        try {
            PreparedStatement ps = conexion.conectar().prepareStatement(stmt);
            ps.setString(1,nombre);
            ps.setString(2,apellido);
            ps.setString(3,cedula);
            ps.setString(4,direccion);
            ps.setString(5,rol);
            if(rol.equals("Medio Tiempo")){
                String stmt1 = "UPDATE empleados SET estado = '' WHERE rol = \"Medio Tiempo\"";
                PreparedStatement ps1 = conexion.conectar().prepareStatement(stmt1);
                ps1.executeUpdate();
                ps1.close();
            }
            ps.setDouble(7, salarioBruto);
            ps.setInt(8,codigo);

            ps.executeUpdate();//se ejecuta la actualizacion en la base de datos
            ps.close();

        } catch(SQLException ex) {
            System.out.println("Existe un cliente con ese código");

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


    /**
     * Metodo que muestra el código, nombre, apellido y cédula de todos los empleados registrados
     */
    public void mostrarTodos(){
        try {
            Statement st = conexion.conectar().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM empleados");

            System.out.println("Codigo  Nombre Completo   Cédula\n---------------------------------");
            while(rs.next()){
                System.out.println(rs.getString(1) + "  " + rs.getString(2) + " " +rs.getString(3) + "  " + rs.getString(4));
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            System.err.println("Algo ha salido mal...");

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


    /**
     * Metodo que enseña el código, nombre, apellido, cédula, salario y fecha de inicio
     * de labores de un empleado.
     * @param codigo El parámetro es el código único del Empleado
     */
    public void consultarEmpleado(int codigo){
        String stmt = "SELECT * FROM empleados WHERE codigo_empleado = " + codigo;

        try {
            Statement ps = conexion.conectar().createStatement();
            ResultSet rs = ps.executeQuery(stmt);

            System.out.println("\nEMPLEADO\nCódigo: " +
            rs.getString(1) + "\nNombre: " + rs.getString(2) +
            "\nApellido: " + rs.getString(3) + "\nCédula: " + rs.getString(4)
            + "\nSalario: RD$" + rs.getInt(8) + "\nFecha de Inicio de Labores: " + rs.getString(9));

            rs.close();
            ps.close();

        } catch (SQLException ex){
            System.err.println("No existe un empleado con este código");

        } finally {

            try {
                if (conexion != null) {
                    conexion.conectar().close();
                }
            } catch (SQLException ex) {

                Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE,null,ex);

            }
        }
    }//Cierre de metodo

}// Cierre de Clase