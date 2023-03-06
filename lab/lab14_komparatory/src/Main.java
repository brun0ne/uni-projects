import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("== AUTA ==");

        Samochody samochody = new Samochody();

        Scanner scanner = new Scanner(System.in);
        String cmd;
        boolean go = true;
        do{
            System.out.println("");
            System.out.println("1. Wyświetl wszystkie auta");
            System.out.println("2. Dodaj auto");
            System.out.println("3. Dodaj testowy zestaw aut");
            System.out.println("4. Sortuj marką (alfabetycznie)");
            System.out.println("5. Sortuj LK (rosnąco)");
            System.out.println("6. Sortuj marką i LK");
            System.out.println("7. Znajdź auto z największym zużyciem i jego pozycję");
            System.out.println("nieprawidłowa opcja kończy program");

            cmd = scanner.nextLine();

            switch (cmd){
                case "1" -> {
                    System.out.println(">> Wszystkie auta: ");
                    samochody.printAll();
                }
                case "2" -> {
                    System.out.println(">> Wybierz rodzaj auta: ");
                    System.out.println("1. Auto osobowe");
                    System.out.println("2. Auto ciężarowe");
                    String rodzajStr = scanner.nextLine();

                    System.out.println(">> Marka: ");
                    String markaStr = scanner.nextLine();

                    System.out.println(">> Liczba kilometrów: ");
                    String lkStr = scanner.nextLine();

                    System.out.println(">> Numer nadwozia: ");
                    String nrNadwoziaStr = scanner.nextLine();

                    System.out.println(">> Czy diesel? (T/F) ");
                    String czyDieselStr = scanner.nextLine();

                    boolean czyDiesel = false;
                    if (czyDieselStr.equals("T"))
                        czyDiesel = true;
                    else if (czyDieselStr.equals("F"))
                        czyDiesel = false;
                    else {
                        System.out.println("Niepoprawna opcja: diesel");
                        break;
                    }

                    System.out.println(">> Model:");
                    String modelStr = scanner.nextLine();

                    System.out.println(">> Zużycie: ");
                    String zuzycieStr = scanner.nextLine();

                    boolean czyKratka = false;
                    if (rodzajStr.equals("2")){
                        System.out.println(">> Czy jest kratka? (T/F)");
                        String kratkaStr = scanner.nextLine();

                        if (kratkaStr.equals("T"))
                            czyKratka = true;
                        else if (kratkaStr.equals("F"))
                            czyKratka = false;
                        else {
                            System.out.println("Niepoprawna opcja: kratka");
                            break;
                        }
                    }

                    Auto auto = null;
                    if (rodzajStr.equals("1")){
                        try {
                            auto = new AutoOsobowe(markaStr.strip(), Integer.parseInt(lkStr),
                                    Long.parseLong(nrNadwoziaStr), czyDiesel, modelStr, Double.parseDouble(zuzycieStr));
                        }
                        catch (NumberFormatException e){
                            System.out.println("Któraś z opcji została podana w niepoprawnym formacie :(");
                            break;
                        }
                    }
                    else if(rodzajStr.equals("2")){
                        try {
                            auto = new AutoCiezarowe(markaStr.strip(), Integer.parseInt(lkStr),
                                    Long.parseLong(nrNadwoziaStr), czyDiesel, modelStr, Double.parseDouble(zuzycieStr), czyKratka);
                        }
                        catch (NumberFormatException e){
                            System.out.println("Któraś z opcji została podana w niepoprawnym formacie :(");
                            break;
                        }
                    }

                    if (auto != null) {
                        samochody.dodajAuto(auto);
                        System.out.println(">> Pomyślnie dodano auto!");
                    }
                }
                case "3" -> {
                    Auto test1 = new AutoOsobowe("Audi", 100, 5, true, "A5", 5);
                    Auto test2 = new AutoOsobowe("Opel", 45, 6, false, "Astra", 4);
                    Auto test3 = new AutoCiezarowe("Tesla", 70, 7, false, "X5", 10, false);

                    samochody.dodajAuto(new Auto[]{test1, test2, test3});

                    System.out.println(">> Dodano testowy zestaw!");
                }
                case "4" -> {
                    samochody.sortByMarka();
                    System.out.println(">> Posortowano!");
                }
                case "5" -> {
                    samochody.sortByLK();
                    System.out.println(">> Posortowano!");
                }
                case "6" -> {
                    samochody.sortByMarkaThenLK();
                    System.out.println(">> Posortowano!");
                }
                case "7" -> {
                    samochody.printAutoWithLargestZuzycie();
                }
                default -> {
                    go = false;
                }
            }
        }while (go);
    }
}