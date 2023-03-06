public class KartaPodstawowa extends KartaKlienta{
    KartaPodstawowa(){
        super();
    }

    KartaPodstawowa(int numer, String nazwisko){
        super(numer, nazwisko);
    }

    @Override
    public int rabat(){
        return 0;
    }
}
