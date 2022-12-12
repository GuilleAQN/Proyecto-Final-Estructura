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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Conexion cc = new Conexion(); //Se crea un objeto de tipo connection con el fin de que los cambios realizados se realicen en la base de datos correspondiente
            Connection cn = cc.conectar();

            PreparedStatement ps = cn.prepareStatement("INSERT INTO empleados VALUES(?,?,?,?,?,?,?,?);"); //sentencia sql para añadira datos a la tabla empleados de la base de datos
            
            String id_empleado = sc.next();//se utiliza el scanner para que el usuario ingrese el valor que desea
            ps.setString(1,id_empleado);//posteriormente se coloca lo posicion y la variable con el valor introducido en la base de datos

            String nombre = sc.next();
            ps.setString(2,nombre);

            String apellido = sc.next();
            ps.setString(3,apellido);

            String cedula = sc.next();
            ps.setString(4,cedula);

            String direccion = sc.next();
            ps.setString(5,direccion);

            String rol = sc.next();
            ps.setString(6,rol);

            int estado = sc.nextInt();
            ps.setInt(7,estado);

            double Salario_bruto = sc.nextDouble();
            ps.setDouble(8, Salario_bruto); 

            ps.executeUpdate();//se ejecuta la actualizacion en la base de datos

        }
        catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE,null,ex);// se captura este posible error en un catch
        }
        
    }// Cierre de Metodo
}//Cierre de Clase