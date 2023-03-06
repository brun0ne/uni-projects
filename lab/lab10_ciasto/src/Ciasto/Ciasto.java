package Ciasto;

import CiastoJablkowe.Cwiartki;
import CiastoJablkowe.Jablko;
import CiastoJablkowe.Kostka;
import CiastoSliwkowe.Polowki;
import CiastoSliwkowe.Sliwka;
import CiastoSliwkowe.Zmiksowane;

public abstract class Ciasto {
    private String algorytmInfoJablko;
    private String algorytmInfoliwka;

    private Jablko algorytmJablko;
    private Sliwka algorytmSliwka;

    // INFO

    public void setAlgorytmInfoJablko(String algorytmInfoJablko) {
        this.algorytmInfoJablko = algorytmInfoJablko;
    }
    public void setAlgorytmInfoSliwka(String algorytmInfoliwka) {
        this.algorytmInfoliwka = algorytmInfoliwka;
    }

    public String getAlgorytmInfoJablko() {
        return this.algorytmInfoJablko;
    }

    public String getAlgorytmInfoSliwka() {
        return this.algorytmInfoliwka;
    }

    // wykonaj

    public void wykonajCiastoJablkowe(){ // szarlotka
        System.out.println("--- Pora na wykonanie ciasta jabłkowego ---");
        System.out.println("Najpierw przygotujemy owoce: ");
        this.algorytmJablko.przygotowanieJablka();
        System.out.println("Następnie pieczemy. Gotowe!");
    }

    public void wykonajCiastoSliwkowe(){
        System.out.println("--- Pora na wykonanie ciasta śliwkowego ---");
        System.out.println("Najpierw przygotujemy owoce: ");
        this.algorytmSliwka.przygotowanieSliwki();
        System.out.println("Następnie pieczemy. Gotowe!");
    }

    // ustaw

    public void ustawCiastoJablkowe(Jablko algorytmJablko){
        this.algorytmJablko = algorytmJablko;

        if (algorytmJablko instanceof Kostka)
            this.setAlgorytmInfoJablko("Jabłko zostanie pokrojone w kostkę.");
        else if (algorytmJablko instanceof Cwiartki)
            this.setAlgorytmInfoJablko("Jabłko zostanie pokrojone w ćwiartki.");
    }

    public void ustawCiastoSliwkowe(Sliwka algorytmSliwka){
        this.algorytmSliwka = algorytmSliwka;

        if (algorytmSliwka instanceof Polowki)
            this.setAlgorytmInfoSliwka("Śliwka zostanie podzielona na połówki.");
        else if (algorytmSliwka instanceof Zmiksowane)
            this.setAlgorytmInfoSliwka("Śliwka zostanie zmiksowana.");
    }

    public abstract void wyswietlInfo();

    public void wyswietlInfo(String kto, String algInfo){
        System.out.printf("[INFO] %s piecze ciasto Jabłkowe przygotowując owoce w sposób:%n\t[%s]%n", kto, algInfo);
    };
}
