package ControlDeDatos;
import java.sql.*;

public class main {
    public static void main(String[] args) {
        Conexion cc = new Conexion();
        Connection cn = cc.conectar();
    }
}
