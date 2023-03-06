import java.util.Locale;

public abstract class Auto {
    private final String marka;
    private final int lk;
    private final long nrNadwozia;
    private final boolean diesel;
    private final double zuzycie;

    public Auto(){
        this.marka = "";
        this.lk = 0;
        this.nrNadwozia = 0;
        this.diesel = false;
        this.zuzycie = 0;
    }

    public Auto(String marka, int lk, long nrNadwozia, boolean diesel, double zuzycie){
        this.marka = marka;
        this.lk = lk;
        this.nrNadwozia = nrNadwozia;
        this.diesel = diesel;
        this.zuzycie = zuzycie;
    }

    public String getMarka(){
        return this.marka;
    }

    public int getLk() {
        return this.lk;
    }

    public double getZuzycie(){
        return this.zuzycie;
    }

    abstract public double ilePaliwa();

    public String toString(String rodzaj){
        return String.format(Locale.US, "Auto %-10s | Marka: %-10s | LK: %-5d | Nr nadwozia: %-5d | Diesel: %-6b | Zużycie: %-8.2f",
                rodzaj, this.marka, this.lk, this.nrNadwozia, this.diesel, this.zuzycie);
    }
}
