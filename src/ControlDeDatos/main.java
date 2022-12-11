package ControlDeDatos;
/**
 * Clase con el método para inicializar la conexión de la Base de Datos "Nomina"
 * @author Leandro Gonzales
 * @since 11/12/2022
 */

// Interfaces importadas
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;


public class main {
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            Conexion cc = new Conexion();
            Connection cn = cc.conectar();

            PreparedStatement ps = cn.prepareStatement("INSERT INTO empleados VALUES(?,?,?,?,?,?,?,?);");
            
            String id_empleado = sc.next;
            ps.setString(1,id_empleado);

            String nombre = sc.next;
            ps.setString(2,nombre);

            String apellido = sc.next;
            ps.setString(3,apellido);

            String cedula = sc.next;
            ps.setString(4,cedula);

            String direccion = sc.next;
            ps.setString(5,direccion);

            String rol = sc.next;
            ps.setString(6,rol);

            int estado = sc.next;
            ps.setInt(7,estado);

            Double Salario_bruto = sc.nextDouble;
            ps.setDouble(8, Salario_bruto);

        }catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE,null,ex);
        }
    }// Cierre de Metodo
}//Cierre de Clase