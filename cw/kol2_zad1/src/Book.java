import java.util.Objects;

public class Book {
    private Autor autor;
    private String title;
    private String wydawnictwo;
    private int rokWydania;

    Book(Autor autor, String title, String wydawnictwo, int rokWydania){
        this.autor = autor;
        this.title = title;
        this.wydawnictwo = wydawnictwo;
        this.rokWydania = rokWydania;
    }

    public Autor getAutor() {
        return this.autor;
    }

    public String getTitle() {
        return this.title;
    }

    public String getWydawnictwo() {
        return this.wydawnictwo;
    }

    public int getRokWydania() {
        return this.rokWydania;
    }

    @Override
    public String toString(){
        return String.format("Tytul: \"%s\", Wydawnictwo: \"%s\", Rok wydania: %d, Autor: %s",
                this.title, this.wydawnictwo, this.rokWydania, this.autor.toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass())
            return false;

        return ((Book) obj).hashCode() == this.hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.title); // bez powtorzen **tytulow**
    }
}
