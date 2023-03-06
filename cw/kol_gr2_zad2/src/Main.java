import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj nazwę pliku zawierającego dane: ");
        String in_filename = scanner.nextLine().trim();

        System.out.println("Podaj nazwę pliku wyjściowego do zapisu: ");
        String out_filename = scanner.nextLine().trim();

        Dziennik dziennik = new Dziennik(in_filename, out_filename);

        dziennik.saveAbove3_sortByAverageDescending();
    }
}