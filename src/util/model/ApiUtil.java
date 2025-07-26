package util.model;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiUtil {

    public static String api = "https://api.playhive.com/v0/game/all/all/";

    public static String getJson(String username) {
        try {
            URL url = new URL(api + username);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();
            if (status == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();
                connection.disconnect();

                System.out.println(response);
                return response.toString();
            } else {
                System.out.println("HTTP Error: " + status);
                connection.disconnect();
                JOptionPane.showMessageDialog(null, "User not found.", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}