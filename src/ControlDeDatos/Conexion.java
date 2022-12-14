package ControlDeDatos;
/**
 * Clase con el método para hacer la conexión de la Base de Datos "Nomina"
 * @author Leandro Gonzales
 * @since 11/12/2022
 */

// Interfaces importadas
import java.sql.*;

public class Conexion {

    // Campos de la Clase
    Connection conectar = null;

    /**
     * Metodo que hace la conexión a la Base de Datos.
     */
    public Connection conectar(){
        
        try {// Prueba la conexión a la Base de Datos
            Class.forName("org.sqlite.JDBC");
            String jdbcURL = "jdbc:sqlite:nomina.db";
            conectar = DriverManager.getConnection(jdbcURL);
        } 
        catch (Exception e) { // En caso, de que no la Base de Datos, devuelve un mensaje
            System.out.println(e.getMessage());
        }
        return conectar;
    }//Cierre de metodo
    /**
     * @return Devuelve la conexión la Base de Datos
     */

}//Cierre de la clase