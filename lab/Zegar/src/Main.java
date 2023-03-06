public class Main {
    public static void main(String[] args) {
        Zegar default_zegar = new Zegar(); // default zegar
        Zegar custom_zegar = new Zegar(15, 20, 5); // 15:20:05

        // wypisz
        System.out.println("Default zegar: ");
        default_zegar.wypisz();
        System.out.println("Zegar(15, 20, 5): ");
        custom_zegar.wypisz();

        System.out.println();

        // przesun
        default_zegar.przesun(0, 0, 20);
        custom_zegar.przesun(2, 5, 1);

        default_zegar.przesun(25, 0, 0);

        // wypisz
        System.out.println("Default zegar - przesunięty o 20s: ");
        default_zegar.wypisz();
        System.out.println("Zegar(15, 20, 5) - przesunięty o 2h 5min 1s: ");
        custom_zegar.wypisz();
    }
}