public class Autor {
    private String nazwisko;
    private String imie;

    Autor(String imie, String nazwisko){
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return this.imie;
    }

    public String getNazwisko() {
        return this.nazwisko;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko){
        this.nazwisko = nazwisko;
    }

    @Override
    public String toString(){
        return String.format("%s %s", this.nazwisko, this.imie);
    }
}
