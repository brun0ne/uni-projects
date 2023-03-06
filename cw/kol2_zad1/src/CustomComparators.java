import java.util.Comparator;

public class CustomComparators {
    public static class BookByYearsFromNewest implements Comparator<Book> {
        @Override
        public int compare(Book o1, Book o2) {
            return Integer.compare(o2.getRokWydania(), o1.getRokWydania());
        }
    }

    public static class BookAlphabeticalComparatorByTitle implements Comparator<Book> {
        @Override
        public int compare(Book o1, Book o2) {
            return o1.getTitle().compareTo(o2.getTitle());
        }
    }

    public static class BookAlphabeticalComparatorByAuthor implements Comparator<Book> {
        @Override
        public int compare(Book o1, Book o2){
            if (!o1.getAutor().getNazwisko().equals(o2.getAutor().getNazwisko()))
                return o1.getAutor().getNazwisko().compareTo(o2.getAutor().getNazwisko());

            if (!o1.getAutor().getImie().equals(o2.getAutor().getImie()))
                return o1.getAutor().getImie().compareTo(o2.getAutor().getImie());

            return o1.getTitle().compareTo(o2.getTitle());
        }
    }

    public static class AuthorAlphabeticalComparator implements Comparator<Autor>{
        @Override
        public int compare(Autor o1, Autor o2){
            if (!o1.getNazwisko().equals(o2.getNazwisko()))
                return o1.getNazwisko().compareTo(o2.getNazwisko());

            return o1.getImie().compareTo(o2.getImie());
        }
    }
}
