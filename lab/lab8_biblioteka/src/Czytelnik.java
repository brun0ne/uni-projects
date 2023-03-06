public class Czytelnik extends Osoba{
    final int n;              // liczba wypożyczeń
    final Ksiazka[] books;    // tablica wypożyczeń

    Czytelnik(){
        super("", "");
        this.n = 0;
        this.books = null;
    }

    Czytelnik(String surname, String pesel, Ksiazka[] books){
        super(surname, pesel);

        this.n = books.length;
        this.books = books;
    }

    @Override
    public double calculate(){
        if(this.books == null)
            return 0;

        double sum_all = 0;

        for(Ksiazka book : this.books){
            sum_all += book.getPunishment();
        }

        return sum_all;
    }

    @Override
    public String toString(){
        return String.format("%s [n=%d]", super.toString(), this.n);
    }

    public void displayBooks(){ // metoda wyświetlająca wszystkie wypożyczenia
        System.out.println("Wszystkie wypożyczenia: ");

        if (this.books == null){
            System.out.println("<brak>");
            return;
        }

        for (Ksiazka book : this.books){
            System.out.printf("> %s%n", book.toString());
        }
    }
}
