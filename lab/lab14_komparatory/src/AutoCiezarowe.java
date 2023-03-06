import java.util.Locale;

public class AutoCiezarowe extends Auto{
    private final String model;
    private final boolean kratka;

    public AutoCiezarowe(){
        super();

        this.model = "";
        this.kratka = false;
    }

    public AutoCiezarowe(String marka, int lk, long nrNadwozia, boolean diesel, String model, double zuzycie, boolean kratka){
        super(marka, lk, nrNadwozia, diesel, zuzycie);

        this.model = model;
        this.kratka = kratka;
    }

    @Override
    public double ilePaliwa() {
        return this.getLk() / this.getZuzycie();
    }

    @Override
    public String toString(){
        return String.format(Locale.US, "%s| Model: %-6s | Kratka: %-6b", super.toString("Ciężarowe"),
                this.model, this.kratka);
    }
}
