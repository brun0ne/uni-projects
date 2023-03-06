import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Sklep {
    private final Transakcja[] transakcje;
    private int n = 0;

    Sklep(){
        this.transakcje = new Transakcja[100];
    }

    public void printMenu(){
        System.out.println("Witamy w Sklepie! Wybierz opcję: ");
        System.out.println();
        System.out.println("  1. Wstaw kilka transakcji z różnymi kartami");
        System.out.println("  2. Wyświetl transakcje");
        System.out.println("  3. Dodaj jedną transakcję");
        System.out.println("  4. Policz transakcje z Kartą Seniora");
        System.out.println("  5. Wyświetl klienta z Kartą Studenta, który zapłacił najwięcej");
        System.out.println("  6. Zapisz do pliku transakcje z użyciem Karty Studenta");
        System.out.println();
        System.out.println("<dowolny inny znak kończy program>");
    }

    ///// POMOCNICZE
    public void addToArray(Transakcja[] t_arr){
        for (Transakcja t : t_arr){
            this.transakcje[n] = t;
            n++;
        }
    }


    ///// POMOCNICZE

    ////// MENU ACTIONS

    public void zestawStartowy(){
        Transakcja t1 = new Transakcja();
        Transakcja t2 = new Transakcja(2);
        Transakcja t3 = new Transakcja(10, new KartaSeniora(1, "Kowalski"));
        Transakcja t4 = new Transakcja(10, new KartaStudenta());

        addToArray(new Transakcja[]{t1, t2, t3, t4});
    }

    public void wyswietlWszystkie(){
        System.out.println(">> Wszystkie transakcje w tablicy:");
        if (n == 0 )
            System.out.println(" <brak >");
        for (int i = 0; i < n; i++){
            System.out.println(this.transakcje[i].toString());
        }
    }

    public void dodajTransakcje(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("> Kwota transakcji: ");
        double kwota = scanner.nextDouble();

        System.out.println("> Rodzaj karty: ");
        System.out.println("   1. Brak ");
        System.out.println("   2. Podstawowa");
        System.out.println("   3. Studenta");
        System.out.println("   4. Seniora");

        scanner.nextLine();
        String option = scanner.nextLine();
        KartaKlienta karta = null;

        switch (option){
            case "1":
            {
                break;
            }
            case "2":
            {
                karta = new KartaPodstawowa();
                break;
            }
            case "3":
            {
                karta = new KartaStudenta();
                break;
            }
            case "4":
            {
                karta = new KartaSeniora();
                break;
            }
            default: {
                System.out.println("[!] Błędna opcja, anulowano.");
                return;
            }
        }

        if (karta != null){
            System.out.println("> Podaj numer: ");
            String numer_str = scanner.nextLine();
            int numer;
            try {
                 numer = Integer.parseInt(numer_str);
            }
            catch(Exception e){
                numer = 0;
                System.out.println("Błędny numer, ustawiono 0.");
            }

            System.out.println("> Podaj nazwisko: ");
            String nazwisko = scanner.nextLine();

            karta.setNazwisko(nazwisko);
            karta.setNumer(numer);

            addToArray(new Transakcja[]{new Transakcja(kwota, karta)});
        }
        else {
            addToArray(new Transakcja[]{new Transakcja(kwota)});
        }


        System.out.println("Dodano transakcję!");
    }

    public void policzTrSeniora(){
        int count = 0;
        for (int i = 0; i < n; i++){
            if (this.transakcje[i].karta != null && this.transakcje[i].karta instanceof KartaSeniora)
                count += 1;
        }
        System.out.printf("> Transakcje dokonane z Kartą Seniora: %d%n", count);
    }

    public void znajdzNajbogatszegoKlientaZKartaStudenta(){
        HashMap<KartaKlienta, Double> studenci = new HashMap<>();

        for (int i = 0; i < n; i++){
            if (this.transakcje[i].karta != null && this.transakcje[i].karta instanceof KartaStudenta){
                if (!studenci.containsKey(this.transakcje[i].karta))
                    studenci.put(this.transakcje[i].karta, 0.0);

                studenci.put(this.transakcje[i].karta, studenci.get(this.transakcje[i].karta) + this.transakcje[i].kwotaDoZaplaty());
            }
        }

        if (studenci.size() == 0){
            System.out.println("[!] Nie znaleziono żadnego klienta z Kartą Studenta.");
            return;
        }

        Map.Entry<KartaKlienta, Double> najbogatszy = null;
        for (Map.Entry<KartaKlienta, Double> student : studenci.entrySet()){
            if (najbogatszy == null || student.getValue() > najbogatszy.getValue())
                najbogatszy = student;
        }
        System.out.println("Najwięcej ze studentów wydał: ");
        System.out.printf("[%s]: %.2f%n", najbogatszy.getKey().toString(), najbogatszy.getValue());
    }

    public void zapiszDoPlikuTrStudentow(){
        BufferedWriter buffered_writer = null;

        try {
            File outfile = new File("transakcje_studentow.txt");
            if (!outfile.exists())
                outfile.createNewFile();

            FileWriter fw = new FileWriter(outfile);
            buffered_writer = new BufferedWriter(fw);

            for (int i = 0; i < n; i++){
                buffered_writer.write(String.format("%s%n", this.transakcje[i].toString()));
            }

            System.out.println("Zapisano transakcje studentów do pliku transakcje_studentow.txt");
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally
        {
            try {
                if (buffered_writer != null)
                    buffered_writer.close();
            }
            catch(Exception ex){
                System.out.println("Error in closing the BufferedWriter");
                ex.printStackTrace();
            }
        }
    }

    ////// MENU ACTIONS

    public boolean doAction(String input){
        input = input.toLowerCase().strip();

        switch ( input ){
            case "1": // Wstaw kilka transakcji z różnymi kartami
            {
                zestawStartowy();
                break;
            }
            case "2": // Wyświetl transakcje
            {
                wyswietlWszystkie();
                break;
            }
            case "3": // Dodaj jedną transakcję
            {
                dodajTransakcje();
                break;
            }
            case "4": // Policz transakcje z Kartą Seniora
            {
                policzTrSeniora();
                break;
            }
            case "5": // Wyświetl klienta z Kartą Studenta, który zapłacił najwięcej
            {
                znajdzNajbogatszegoKlientaZKartaStudenta();
                break;
            }
            case "6": // Zapisz do pliku transakcje z użyciem Karty Studenta
            {
                zapiszDoPlikuTrStudentow();
                break;
            }
            default:
                return false;
        }
        return true;
    }

    public void main(){
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        do {
            printMenu();
            String input = scanner.nextLine();

            loop = doAction(input);
        }
        while(loop);
    }
}
