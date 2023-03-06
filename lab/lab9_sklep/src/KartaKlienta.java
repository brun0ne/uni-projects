public abstract class KartaKlienta {
    static public int inc_numer = 0;
    private int numer;
    private String nazwisko;

    KartaKlienta(){
        this.numer = inc_numer;
        this.nazwisko = "";

        inc_numer += 1;
    }

    KartaKlienta(String nazwisko){
        this.numer = inc_numer;
        this.nazwisko = nazwisko;
    }

    KartaKlienta(int numer, String nazwisko){
        this.numer = numer;
        this.nazwisko = nazwisko;
    }

    public void setNazwisko(String nazwisko){
        this.nazwisko = nazwisko;
    }

    public void setNumer(int numer){
        this.numer = numer;
    }

    @Override
    public String toString(){
        if (this.nazwisko == null || this.nazwisko.equals(""))
            return String.format("numer: %d, nazwisko: <nie podano>", this.numer);

        return String.format("numer: %d, nazwisko: %s", this.numer, this.nazwisko);
    }

    @Override
    public int hashCode()
    {
        return String.format("%d %s", this.numer, this.nazwisko).hashCode();
    }

    @Override
    public boolean equals(Object o)
    {
        return this.hashCode() == o.hashCode();
    }

    public abstract int rabat();
}
