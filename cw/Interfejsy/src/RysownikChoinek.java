public class RysownikChoinek extends Choinka{
    public void setStrategia(SposobNaChoinke sposob){
        this.sposob = sposob;
    }

    public void narysuj(){
        int n = 10;

        this.sposob.narysujChoinke(n);
    }
}
