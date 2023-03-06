import Ciasto.Ciasto;
import Ciasto.PieczeBabcia;
import Ciasto.PieczeDziadek;

import java.util.Scanner;

public class Main {
    public static void configure(Ciasto ciasto){
        System.out.printf(">> Wybierz ciasto, które upiecze [%s]%n", ciasto.getClass().getName());
        System.out.println("1. Jabłkowe");
        System.out.println("2. Śliwkowe");

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        switch (choice){
            case "1" -> {
                ciasto.
            }
        }
    }

    public static void info(Ciasto ciasto){

    }

    public static void execute(Ciasto ciasto){

    }

    public static void menu(){
        Ciasto ciastoDziadka = new PieczeDziadek();
        Ciasto ciastoBabci = new PieczeBabcia();

        boolean loop = true;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("MENU");
            System.out.println("1. Konfiguruj Babcię");
            System.out.println("2. Konfiguruj Dziadka");
            System.out.println("3. Info Babci");
            System.out.println("4. Info Dziadka");
            System.out.println("5. Babciu, piecz");
            System.out.println("6. Dziadku, piecz");

            String input = scanner.nextLine();

            switch (input) {
                case "1" -> {
                    configure(ciastoBabci);
                }
                case "2" -> {
                    configure(ciastoDziadka);
                }
                case "3" -> {
                    info(ciastoBabci);
                }
                case "4" -> {
                    info(ciastoDziadka);
                }
                case "5" -> {
                    execute(ciastoBabci);
                }
                case "6" -> {
                    execute(ciastoDziadka);
                }
            }
        } while(loop);
    }

    public static void main(String[] args) {
        Ciasto ciastoBabci = new PieczeBabcia();
        ciastoBabci.wyswietlInfo();

        System.out.println();

        Ciasto ciastoDziadka = new PieczeDziadek();
        ciastoDziadka.wyswietlInfo();

        System.out.println();
    }
}