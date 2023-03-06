public class KartaStudenta extends KartaKlienta{
    KartaStudenta(){
        super();
    }

    KartaStudenta(int numer, String nazwisko){
        super(numer, nazwisko);
    }

    @Override
    public int rabat(){
        return 10;
    }
}
