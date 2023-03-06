package Projekt_Main;
import Bukiet.Bukiet;
import Bukiet.Kwiat;
import java.util.Random;

public class Main {
    public static void printBukiety(Bukiet[] bukiety){
        int i = 0;
        for(Bukiet bukiet : bukiety){
            System.out.printf("Bukiet o indeksie=%d kwiat=%d dostepny=%b%n", i, bukiet.getKwiat().getNazwa(), bukiet.getDostepny());
            i++;
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        final int ILE = 5;
        Bukiet[] kwiaciarnia = new Bukiet[ILE];

        for (int i = 0; i < ILE; i++){
            kwiaciarnia[i] = new Bukiet(new Kwiat(rand.nextInt(1,6+1)));
        }

        printBukiety(kwiaciarnia);

        System.out.println("____ i=2 jestwKwiaciarni() (Florysta tworzy) ____");
        kwiaciarnia[2].jestwKwiaciarni();
        printBukiety(kwiaciarnia);

        System.out.println("____ i=2 brakwKwiaciarni() (Florysta sprzedaje) ____");
        kwiaciarnia[2].brakwKwiaciarni();
        printBukiety(kwiaciarnia);

        System.out.println("____ i=3 getStan() ____");
        System.out.println(kwiaciarnia[3].getStan());
    }
}