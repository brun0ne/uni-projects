import java.util.Locale;

public class AutoOsobowe extends Auto{
    private final String model;

    public AutoOsobowe(){
        super();

        this.model = "";
    }

    public AutoOsobowe(String marka, int lk, long nrNadwozia, boolean diesel, String model, double zuzycie){
        super(marka, lk, nrNadwozia, diesel, zuzycie);

        this.model = model;
    }

    @Override
    public double ilePaliwa() {
        return this.getLk() / this.getZuzycie();
    }

    @Override
    public String toString(){
        return String.format(Locale.US, "%s| Model: %-6s", super.toString("Osobowe"),
                this.model);
    }
}
