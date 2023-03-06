public class Transakcja {
    static int inc_ID = 0;
    private final int ID;

    double kwota;
    KartaKlienta karta;

    Transakcja(){
        this.ID = inc_ID;
        inc_ID++;

        this.kwota = 0;
        this.karta = null;
    }

    Transakcja(double kwota){
        this();

        this.kwota = kwota;
    }

    Transakcja(double kwota, KartaKlienta karta){
        this();

        this.kwota = kwota;
        this.karta = karta;
    }

    @Override
    public String toString(){
        if (this.karta == null)
            return String.format("ID: %d | kwota: %.2f | karta: <brak> | kwota do zapłaty: %.2f", this.ID, this.kwota, this.kwotaDoZaplaty());

        return String.format("ID: %d | kwota: %.2f | karta (%s): [%s] | kwota do zapłaty: %.2f", this.ID, this.kwota, this.karta.getClass().toString(), this.karta.toString(), this.kwotaDoZaplaty());
    }

    public double kwotaDoZaplaty(){
        if (this.karta == null)
            return this.kwota;

        return this.kwota * (1 - this.karta.rabat() / 100f);
    }
}
