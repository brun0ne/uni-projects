import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Ewidencja ewidencja = new Ewidencja();

        // Kompozytorzy
        Kompozytor marek = new Kompozytor("Marek", "Kompozytoriusz");
        Kompozytor antoni = new Kompozytor("Antoni", "Augustus");
        Kompozytor uwu = new Kompozytor("uwu", "owo");

        // Utwory
        Utwor odaDoA = new Utwor("A - oda", 35, marek);
        Utwor odaDoB = new Utwor("B - oda", 50, marek);
        Utwor odaDoC = new Utwor("C - oda", 20, marek);

        Utwor odaDoD = new Utwor("D - oda", 5, antoni);

        Utwor odaDoE = new Utwor("E - oda", 100, uwu);
        Utwor odaDoF = new Utwor("F - oda", 50, uwu);

        // CDs
        CD duzo = new CD(new ArrayList<>(Arrays.asList(odaDoB, odaDoA, odaDoC, odaDoE)));
        CD hity = new CD(new ArrayList<>(Arrays.asList(odaDoA, odaDoF, odaDoB)));
        CD antoniego = new CD(new ArrayList<>(List.of(odaDoD)));

        ewidencja.getCDs().add(duzo);
        ewidencja.getCDs().add(hity);
        ewidencja.getCDs().add(antoniego);

        //////////

        //// wyświetlenie utworów z wybranej płyty w kolejności nagrania
        System.out.printf("--- Utwory z płyty numer %d w kolejności nagrania: %n", 0);
        ewidencja.display(ewidencja.getCDbyID(0));

        //// wyświetlenie alfabetyczne utworów ze wszystkich płyt (bez powtórzeń)
        System.out.printf("--- Utwory z wszystkich płyt w kolejności alfabetycznej bez powtórzeń: %n");
        ewidencja.display(ewidencja.allAlphabeticalWithoutDuplicates());

        //// wyświetlenie alfabetyczne utworów danego kompozytora z wybranej płyty
        System.out.printf("--- Utwory kompozytora Marka z płyty numer w kolejności alfabetycznej: %n");
        ewidencja.display(ewidencja.alphabeticalByCD_andKompozytor(1, marek));

        // wyświetlenie alfabetyczne wszystkich utworów wskazanego kompozytora (bez powtórzeń)
        System.out.printf("--- Wszystkie utwory kompozytora uwu owo w kolejności alfabetycznej bez powtórzeń: %n");
        ewidencja.display(ewidencja.allAlphabeticalByKompozytorWithoutDuplicates(uwu));

        // wyświetlenie alfabetyczne wszystkich kompozytorów z wybranej płyty
        System.out.printf("--- Wszyscy kompozytorzy z płyty numer %d w kolejności alfabetycznej: %n", 0);
        ewidencja.displayListOfKompozytor(ewidencja.alphabeticalKompozytorzyOnCD(0));

        // wyświetlenie alfabetyczne wszystkich kompozytorów
        System.out.printf("--- Wszyscy kompozytorzy w kolejności alfabetycznej: %n");
        ewidencja.displayListOfKompozytor(ewidencja.allAlphabeticalKompozytorzy());
    }
}