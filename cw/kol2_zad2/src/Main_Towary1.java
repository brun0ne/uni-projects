import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main_Towary1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String naglowek;
        System.out.println("Numer wykazu:");
        naglowek = scanner.nextLine(); // np. "03/2023"

        ArrayList<Towar> towary = new ArrayList<>();

        System.out.println("Podaj kolejne towary w formacie: ");
        System.out.println("   <nazwa>   <ilosc>   <cena>");
        System.out.println(    "(pusta linijka konczy program)");

        String cmd;
        do {
            cmd = scanner.nextLine();

            String nazwa;
            int ilosc;
            double cena;

            try {
                String[] parts = cmd.split("\s+");

                nazwa = parts[0].trim();
                ilosc = Integer.parseInt(parts[1].trim());
                cena = Double.parseDouble(parts[2].trim());
            }
            catch (Exception e){
                if (cmd.length() > 0)
                    System.out.println("Niepoprawny format :(");

                break;
            }

            towary.add(new Towar(nazwa, ilosc, cena));
        } while(cmd.length() > 0);

        System.out.println("Podaj nazwe pliku wyjsciowego do zapisu:");
        String filename = scanner.nextLine().trim();

        saveToFile(filename, naglowek, towary);
    }

    public static void saveToFile(String filename, String naglowek, ArrayList<Towar> towary){
        BufferedWriter bufferedWriter = null;
        FileWriter fileWriter;

        try {
            fileWriter = new FileWriter(filename);
            bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(String.format("Wykaz towarów nr %s%n", naglowek));
            bufferedWriter.write(String.format("%-15s %-10s %-10s%n", "Nazwa_towaru", "Ilosc", "Cena"));

            for (Towar towar : towary){
                bufferedWriter.write(String.format("%s%n", towar.toString()));
            }
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println("[!] Problem z zapisem do pliku");
        }
        finally {
            try {
                if (bufferedWriter != null)
                    bufferedWriter.close();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}