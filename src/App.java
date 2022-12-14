import Interfaz.InicioDeSesion;

import java.io.IOException;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws InterruptedException, SQLException, IOException {
        InicioDeSesion inicioDeSesion = new InicioDeSesion();
        inicioDeSesion.inicioDeSesion();
    }
}