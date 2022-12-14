import Interfaz.Menu;

import java.io.IOException;
import java.sql.SQLException;
public class App {
    public static void main(String[] args) throws InterruptedException, SQLException, IOException {
        Menu menu = new Menu();
        menu.menuPrincipal();
    }
}
