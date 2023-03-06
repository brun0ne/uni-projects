package FileFormatter;

import java.io.*;
import java.util.ArrayList;

public interface FileFormatter {
    void format(File file);

    static ArrayList<String> readLinesFromFile(File file){
        BufferedReader bufferedReader = null;
        ArrayList<String> lines = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        }
        catch(IOException e){
            // e.printStackTrace();
            System.out.println("Plik nie istnieje lub wystąpił błąd.");
        }
        finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }

        return lines;
    }

    static void writeLinesToFile(ArrayList<String> lines, File file){
        BufferedWriter bufferedWriter = null;

        try {
            FileWriter fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);

            for (String line : lines){
                bufferedWriter.write(String.format("%s%n", line));
            }
        }
        catch (IOException e){
            // e.printStackTrace();
            System.out.println("Plik nie istnieje lub wystąpił błąd.");
        }
        finally {
            try {
                if (bufferedWriter != null)
                    bufferedWriter.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
