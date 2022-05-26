package countingNumbers;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static java.awt.SystemColor.text;

public class countingNumbers {
    public static void main(String[] args) {
        BufferedReader gll = null;

        try {
            File file = new File("newFile.txt");
            try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8)) {
                writer.write ("asd\n");
                writer.write ("Тест\n");
                writer.write("фывыфв21321№*\n");
                
            }

            gll = new BufferedReader(new FileReader("newFile.txt"));
            String line;
            while((line = gll.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
        } finally {
            try {
                gll.close();
            } catch (IOException e) {
                System.out.println("Error: " + e);
        }
    }
    }
}