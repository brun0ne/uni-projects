package Printer;

public class ReversedPrinter implements Printer{
    @Override
    public String print(String text) {
        return new StringBuilder(text).reverse().toString();
    }
}
