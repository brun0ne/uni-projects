import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Ewidencja {
    private ArrayList<Book> books = new ArrayList<>();

    public ArrayList<Book> getBooks() {
        return this.books;
    }

    public void addBook(Book book){ // wpisanie ksiazki na liste
        this.books.add(book);
    }

    public void addBook(ArrayList<Book> books){
        this.books.addAll(books);
    }

    public void displayBooks(ArrayList<Book> books){
        Iterator<Book> it = books.iterator();

        while (it.hasNext()){ // zastosowany Iterator
            Book book = it.next();

            System.out.printf("%s%n", book.toString());
        }
    }

    public ArrayList<Book> removeDuplicates(ArrayList<Book> books){
        HashSet<Book> all = new HashSet<>();
        all.addAll(books);

        return new ArrayList<>(all.stream().toList());
    }

    public ArrayList<Book> allWithoutDuplicatesAlphabeticalByTitle(){
        return new ArrayList<>(
                this.removeDuplicates(this.books).stream()
                .sorted(new CustomComparators.BookAlphabeticalComparatorByTitle())
                .toList()
        );
    }

    public ArrayList<Book> allWithoutDuplicatesAlphabeticalByAuthor(){
        return new ArrayList<>(
                this.removeDuplicates(this.books).stream()
                        .sorted(new CustomComparators.BookAlphabeticalComparatorByAuthor())
                        .toList()
        );
    }

    public ArrayList<Book> withoutDuplicatesAlphabeticalByTitleOnlyBy(Autor autor) {
        return new ArrayList<>(
                this.removeDuplicates(this.books).stream()
                        .filter(obj -> obj.getAutor().equals(autor))
                        .sorted(new CustomComparators.BookAlphabeticalComparatorByTitle())
                        .toList()
        );
    }

    public ArrayList<Autor> getAllAuthors(){
        HashSet<Autor> all = new HashSet<>();

        for (Book book : this.books){
            all.add(book.getAutor());
        }

        return new ArrayList<>(all.stream().toList());
    }

    public ArrayList<Autor> getAllAuthorsAlphabetical(){
        return new ArrayList<>(this.getAllAuthors().stream().
                sorted(new CustomComparators.AuthorAlphabeticalComparator()).toList());
    }

    public void displayAuthors(ArrayList<Autor> authors){
        for (Autor autor : authors){
            System.out.println(autor.toString());
        }
    }

    public ArrayList<Book> getAllByWydawnictwoFromNewest(String wydawnictwo){
        return new ArrayList<>(
                this.removeDuplicates(this.books).stream()
                        .filter(obj -> obj.getWydawnictwo().equals(wydawnictwo))
                        .sorted(new CustomComparators.BookByYearsFromNewest()).toList()
        );
    }
}
