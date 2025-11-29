import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileWriter;
import java.net.URL;

public class WebPageDownload {
    public static void main(String[] args) {
        // Change to the site you want
        String url = "https://www.whatsapp.com/";
        String outputFile = "page.html";

        try {
            URL website = new URL(url);

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(website.openStream())
            );

            FileWriter writer = new FileWriter(outputFile);

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line + "\n");
            }

            reader.close();
            writer.close();
            System.out.println("Downloaded successfully → " + outputFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
