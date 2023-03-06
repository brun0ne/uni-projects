import Observable.InputReader;
import Observers.FileObserver;
import Observers.PrintObserver;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // subjects
        InputReader reader = new InputReader();

        // observers
        FileObserver fileObserver = new FileObserver("plik.txt");
        PrintObserver printObserver1 = new PrintObserver(new Printer.StandardPrinter());
        PrintObserver printObserver2 = new PrintObserver(new Printer.ReversedPrinter());

        // register
        reader.register(fileObserver);
        reader.register(printObserver1);
        reader.register(printObserver2);

        // menu
        Scanner scanner = new Scanner(System.in);
        String cmd;

        System.out.println("--- Obserwowany Tekst \uD83D\uDC40\uD83D\uDC40 ---");
        System.out.println("1. Wprowadź nowy tekst");
        System.out.println("2. Generuj losowy tekst");
        System.out.println("3. Koniec");

        boolean run = true;
        do {
            System.out.print("> ");

            cmd = scanner.nextLine();

            switch (cmd) {
                case "1" -> {
                    System.out.println(">> Nowy tekst: ");
                    String text = scanner.nextLine();
                    reader.changeText(text);
                }
                case "2" -> {
                    System.out.println(">> Generowanie losowego tekstu...");
                    reader.randomText();
                }
                case "3" -> run = false;
                default -> System.out.println(">> Niepoprawna opcja.");
            }

        } while(run);
    }
}