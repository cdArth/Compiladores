package src.TXTDAO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class TXTDAO {

    private static final String FILENAME = "Teste.txt";


    public List<String> readFile() throws IOException, ParseException {
        List<String> Strings = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String line = br.readLine();

            while (line != null) {
                if (line.length() > 0) {
                    Strings.add(line);

                }
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Initializing new file.");
        }
        return Strings;
    }

}
