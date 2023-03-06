package Florysta;

import Bukiet.Bukiet;

public class Florysta {
    public static void tworzBukiet(Bukiet bukiet){
        bukiet.setDostepny(true);
    }

    public static void sprzedajBukiet(Bukiet bukiet){
        bukiet.setDostepny(false);
    }
}
