public class Main {
    public static void main(String[] args) {
        RysownikChoinek choinka = new RysownikChoinek();
        choinka.setStrategia(new Sposob2());
        choinka.narysuj();
    }
}