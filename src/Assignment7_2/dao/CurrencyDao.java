package Assignment7_2.dao;

import Assignment7_2.database.MariaDbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CurrencyDao {

    // Hakee valuutan vaihtokurssin tietokannasta
    public double getExchangeRate(String abbreviation) {
        // SQL-kysely valuutan hakemiseksi
        String query = "SELECT rate_to_usd FROM Currency WHERE abbreviation = ?";
        try (Connection conn = MariaDbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, abbreviation);  // Asetetaan valuutan lyhenne
            ResultSet rs = stmt.executeQuery();

            // Jos valuutta löytyy, palautetaan sen kurssi
            if (rs.next()) {
                return rs.getDouble("rate_to_usd");
            } else {
                // Jos valuuttaa ei löydy, palautetaan -1
                return -1;
            }
        } catch (SQLException e) {
            // Virhe tietokantayhteydessä
            System.err.println("Virhe tietokantayhteydessä: " + e.getMessage());
        }
        return -1; // Virheen tapauksessa palautetaan -1
    }
}
