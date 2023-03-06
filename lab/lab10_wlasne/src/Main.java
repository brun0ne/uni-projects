import FileFormatter.*;
import MyFormatter.*;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File testFile = new File("src/1.txt");

        // menu
        menu(testFile);
    }

    public static void menu(File file){
        CustomizableFormatterAbstract formatter = new FreeFormatter();
        Scanner scanner = new Scanner(System.in);

        boolean loop = true;

        do {
            System.out.println("W jaki sposób chcesz sformatować plik?");
            System.out.println("1. CAPS");
            System.out.println("2. lowercase");
            System.out.println("3. LoSoWe");

            if (formatter instanceof FreeFormatter)
                System.out.println("4. Zmień na BetterFormatter");
            else if (formatter instanceof BetterFormatter)
                System.out.println("4. Zmień na MyFormatter");

            System.out.println("5*. Zapisz stan");
            System.out.println("6*. Wczytaj stan");

            System.out.println("<nieprawidłowa opcja kończy program>");
            String input = scanner.nextLine();

            switch (input) {
                case "1" -> {
                    formatter.setFormatter(new CapsFormatter());
                    formatter.format(file);

                    if (formatter instanceof BetterFormatter)
                        ((BetterFormatter) formatter).doCashback();
                }
                case "2" -> {
                    formatter.setFormatter(new LowerFormatter());
                    formatter.format(file);

                    if (formatter instanceof BetterFormatter)
                        ((BetterFormatter) formatter).doCashback();
                }
                case "3" -> {
                    formatter.setFormatter(new WeirdFormatter());
                    formatter.format(file);

                    if (formatter instanceof BetterFormatter)
                        ((BetterFormatter) formatter).doCashback();
                }
                case "4" -> {
                    if (formatter instanceof FreeFormatter)
                        formatter = new BetterFormatter(formatter.getFileFormatter());
                    else if (formatter instanceof BetterFormatter)
                        formatter = new FreeFormatter(formatter.getFileFormatter());
                }
                case "5" -> {
                    formatter.saveState();
                    System.out.println("[SER] Zapisano stan");
                }
                case "6" -> {
                    formatter = formatter.loadState();
                    System.out.println("[SER] Wczytano stan");
                }
                default -> loop = false;
            }

        } while (loop);
    }
}