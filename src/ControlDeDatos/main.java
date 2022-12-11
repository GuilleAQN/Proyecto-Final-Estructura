package ControlDeDatos;
/**
 * Clase con el método para inicializar la conexión de la Base de Datos "Nomina"
 * @author Leandro Gonzales
 * @since 11/12/2022
 */

// Interfaces importadas
import java.sql.*;

public class main {
    public static void main(String[] args) {
        Conexion cc = new Conexion();
        Connection cn = cc.conectar();
    }// Cierre de Metodo
}//Cierre de Clase