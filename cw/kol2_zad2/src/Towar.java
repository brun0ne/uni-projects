public class Towar {
    private final String nazwa;
    private final int ilosc;
    private final double cena;

    Towar(String nazwa, int ilosc, double cena){
        this.nazwa = nazwa;
        this.ilosc = ilosc;
        this.cena = cena;
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getIlosc() {
        return ilosc;
    }

    public double getCena() {
        return cena;
    }

    @Override
    public String toString(){
        return String.format("%-15s %-10d %-10.0f", this.nazwa, this.ilosc, this.cena);
    }
}
