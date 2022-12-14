package Interfaz;

import ControlDeDatos.Conexion;
import Entidades.Empleado;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InicioDeSesion {

    Scanner scanner = new Scanner(System.in);
    Conexion conexion = new Conexion();
    Menu menu = new Menu();

    public boolean confirmarCredenciales(String usuario, String contraseña){
        String usuarioReal = "";
        String contraseñaReal = "";
        String stmt = "SELECT * FROM usuarios";

        try {
            PreparedStatement st = conexion.conectar().prepareStatement(stmt);
            ResultSet rs = st.executeQuery();

            usuarioReal = rs.getString(2);
            contraseñaReal = rs.getString(3);

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
        if (usuario.equals(usuarioReal) && contraseña.equals(contraseñaReal)) {
            return true;
        }
        return false;
    }

    public void inicioDeSesion() throws SQLException, IOException, InterruptedException {
        boolean salir = true;
        while (salir) {
            System.out.print("\nInicio de Sesión\nIntroduzca las credenciales\nUSUARIO: ");
            String usuario = scanner.next();
            System.out.print("CONTRASEÑA: ");
            String contraseña = scanner.next();

            if (confirmarCredenciales(usuario, contraseña)) {
                System.out.println("\nCredenciales correctas - ENTRANDO AL SISTEMA");
                Thread.sleep(1000);
                System.out.print(".");
                Thread.sleep(1000);
                System.out.print(".");
                Thread.sleep(1000);
                System.out.println(".");
                Thread.sleep(1000);
                salir = false;
                menu.menuPrincipal();
            } else {
                System.out.println("\nCredenciales incorrectas - FAVOR DIGITAR DE NUEVO");
                Thread.sleep(3000);
            }
        }
    }
}
