public class KartaSeniora extends KartaKlienta{
    KartaSeniora(){
        super();
    }

    KartaSeniora(int numer, String nazwisko){
        super(numer, nazwisko);
    }

    @Override
    public int rabat(){
        return 15;
    }
}
