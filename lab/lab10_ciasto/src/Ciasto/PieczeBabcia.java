package Ciasto;

import CiastoJablkowe.Cwiartki;
import CiastoSliwkowe.Polowki;

public class PieczeBabcia extends Ciasto{
    public PieczeBabcia(){
        // wybór strategii
        this.ustawCiastoJablkowe(new Cwiartki());
        this.ustawCiastoSliwkowe(new Polowki());
    }

    public void wyswietlInfo(){
        // wybór ciasta
        super.wyswietlInfo("Babcia", this.getAlgorytmInfoJablko());
        this.wykonajCiastoJablkowe();
    }
}
