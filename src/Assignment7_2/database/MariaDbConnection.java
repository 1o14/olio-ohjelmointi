package Assignment7_2.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDbConnection {
    private static final String URL = "jdbc:mariadb://localhost:3306/CurrencyDB"; // Yhteysosoite
    private static final String USER = "appuser";  // Käyttäjänimi
    private static final String PASSWORD = "app_password"; // Salasana

    // Yhdistetään tietokantaan
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
