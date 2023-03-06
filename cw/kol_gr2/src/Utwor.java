import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

public class Utwor{
    private String title;
    private double time;
    private Kompozytor kompozytor;

    Utwor(String title, double time, Kompozytor kompozytor){
        this.title = title;
        this.time = time;
        this.kompozytor = kompozytor;
    }

    public String getTitle() {
        return this.title;
    }

    public double getTime() {
        return this.time;
    }

    public Kompozytor getKompozytor() {
        return this.kompozytor;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public void setKompozytor(Kompozytor kompozytor) {
        this.kompozytor = kompozytor;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;

        Utwor obj2 = (Utwor) obj;
        return Double.compare(obj2.time, this.time) == 0 && Objects.equals(this.title, obj2.title) && Objects.equals(this.kompozytor, obj2.kompozytor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.title, this.time, this.kompozytor);
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "Utwor: [tytuł: \"%s\", czas: %.2fs, Kompozytor: %s]", this.title, this.time, this.kompozytor.toString());
    }
}
