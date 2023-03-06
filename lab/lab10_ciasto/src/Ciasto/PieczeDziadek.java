package Ciasto;

import CiastoJablkowe.Cwiartki;
import CiastoJablkowe.Kostka;
import CiastoSliwkowe.Zmiksowane;

public class PieczeDziadek extends Ciasto{
    public PieczeDziadek(){
        // wybór strategii
        this.ustawCiastoJablkowe(new Kostka());
        this.ustawCiastoSliwkowe(new Zmiksowane());
    }

    public void wyswietlInfo(){
        // wybór ciasta
        super.wyswietlInfo("Dziadek", this.getAlgorytmInfoSliwka());
        this.wykonajCiastoSliwkowe();
    }
}
