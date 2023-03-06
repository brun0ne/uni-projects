package Bukiet;

import Florysta.Florysta;

public class Bukiet {
    private Kwiat kwiat;
    private boolean dostepny;

    public Bukiet(){
        this.dostepny = false;
    }

    public Bukiet(Kwiat kwiat){
        this();
        this.kwiat = kwiat;
    }

    public void jestwKwiaciarni(){
        Florysta.tworzBukiet(this);
    }
    public void brakwKwiaciarni(){
        Florysta.sprzedajBukiet(this);
    }

    public String getStan(){
        return String.format("Bukiet: {kwiat: %s, dostepny: %b}", this.kwiat.toString(), this.dostepny);
    }

    // get
    public Kwiat getKwiat() {
        return this.kwiat;
    }
    public boolean getDostepny(){
        return this.dostepny;
    }

    // set
    public void setKwiat(Kwiat kwiat) {
        this.kwiat = kwiat;
    }
    public void setDostepny(boolean dostepny) {
        this.dostepny = dostepny;
    }
}
