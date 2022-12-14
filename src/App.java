/**
 * Clase con main para iniciar el sistema
 * @author Omar Aquino
 * @since 11/12/2022
 */

// Interfaces Importadas
import Interfaz.InicioDeSesion;
import java.io.IOException;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws InterruptedException, SQLException, IOException {

        InicioDeSesion inicioDeSesion = new InicioDeSesion();
        inicioDeSesion.inicioDeSesion();

    }//Cierre de metodo

}//Cierre de clase