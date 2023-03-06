package Bukiet;

public class Kwiat {
    private int nazwa;

    public Kwiat(int nazwa){
        this.nazwa = nazwa;
    }
    public int getNazwa() {
        return this.nazwa;
    }

    public void setNazwa(int nazwa) {
        this.nazwa = nazwa;
    }

    public String toString(){
        return String.format("%d", nazwa);
    }
}
