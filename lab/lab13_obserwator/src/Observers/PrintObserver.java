package Observers;

import Printer.*;

public class PrintObserver implements Observer{

    Printer printer;

    public PrintObserver(){
        this.printer = new StandardPrinter();
    }

    public PrintObserver(Printer printer){
        this.printer = printer;
    }

    @Override
    public void update(String text) {
        System.out.printf("!! Zaobserwowano zmianę, wypisuję: %s%n", printer.print(text));
    }
}
