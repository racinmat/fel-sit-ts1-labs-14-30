package helpers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//bit.ly/TS1-csv-reader
public class CSVfileReader {
//comma seperated values

    public static String[] readFirstCSVLine(String filename, String separator) throws IOException, FileNotFoundException {

        BufferedReader reader = new BufferedReader(new FileReader(filename));

        String cur = reader.readLine();
        String[] line = cur.split(separator);

        reader.close();
        return line;
    }

    public static Collection<String[]> readCSVfileToCollection(String filename, String separator) throws IOException, FileNotFoundException {

        ArrayList<String[]> lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));

        String cur = reader.readLine();
        while (cur != null) {
            String[] line = cur.split(separator);
            lines.add(line);
            cur = reader.readLine();
        }

        reader.close();
        return lines;
    }

    public static Collection<String[]> readCSVfileToCollection(String filename) throws IOException {
        return readCSVfileToCollection(filename, ";");
    }
}