import java.util.Objects;

public class Kompozytor {
    private String name;
    private String surname;

    Kompozytor(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;

        Kompozytor obj2 = (Kompozytor) obj;
        return Objects.equals(this.name, obj2.name) && Objects.equals(this.surname, obj2.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.surname);
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.name, this.surname);
    }
}
