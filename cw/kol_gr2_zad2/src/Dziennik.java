import java.io.*;
import java.util.ArrayList;

public class Dziennik {
    private final ArrayList<Student> studenci = new ArrayList<>();
    private final String kierunek;
    private final String opis;

    private final String out_filename;

    Dziennik(String filename, String out_filename){
        this.out_filename = out_filename;

        ArrayList<String> lines = readLinesFromFile(new File(filename));

        if (lines.size() < 2)
            throw new RuntimeException("Niepoprawny format pliku");

        this.kierunek = lines.get(0);
        this.opis = lines.get(1);

        for (String line : lines.subList(2, lines.size())){
            String[] s = line.split("\\(");
            String nameSurname = s[0];
            String rest = s[1];

            String name = nameSurname.split("\s+")[0];
            String surname = nameSurname.split("\s+")[1];

            String index = rest.split("\\)")[0];
            String gradesStr = rest.split("\\)")[1];

            // splitting grades
            String[] gradesStrArray = gradesStr.trim().split("\s+");
            ArrayList<Double> grades = new ArrayList<>();

            for (String str : gradesStrArray){
                grades.add(Double.parseDouble(str));
            }

            // adding the student
            this.studenci.add(new Student(name, surname, Integer.parseInt(index), grades));
        }
    }

    public ArrayList<Student> getStudenci() {
        return this.studenci;
    }

    public void saveAbove3_sortByAverageDescending(){
        String h2 = "Lista studentów, którzy uzyskali zaliczenie";
        ArrayList<String> lines = new ArrayList<>();

        lines.add(this.kierunek);
        lines.add(h2);
        lines.add(String.format("%-5s %-15s %-10s %-10s %s", "Lp", "Numer_indeksu", "Nazwisko", "Imie", "Sr_ocena"));

        int i = 1;

        for (Student st :
                this.studenci.stream().filter(p -> Double.compare(p.average(), 3.0) == 1)
                             .sorted(new CustomComparators.StudentComparatorA()).toList()){
            lines.add(String.format("%-5d %s", i, st.toString()));

            i++;
        }

        writeLinesToFile(lines, new File(this.out_filename));
    }


    /////

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
            e.printStackTrace();
            System.out.println("[!] Plik nie istnieje lub wystąpił błąd.");
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
            e.printStackTrace();
            System.out.println("[!] Plik nie istnieje lub wystąpił błąd.");
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
