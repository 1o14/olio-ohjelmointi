package Assignment3_4_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        String csvUrl = "https://users.metropolia.fi/~jarkkov/temploki.csv";

        try {
            URL url = new URL(csvUrl);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;

            // Lue ja tulosta rivi riviltä
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
        } catch (Exception e) {
            System.out.println("Virhe tiedoston lukemisessa: " + e.getMessage());
        }
    }
}
