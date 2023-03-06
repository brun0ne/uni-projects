public abstract class Osoba {
    private final String surname;
    private final String pesel;

    Osoba(){
        this.surname = "";
        this.pesel = "";
    }

    Osoba(String surname, String pesel){
        this.surname = surname;
        this.pesel = pesel;
    }

    @Override
    public String toString(){
        return String.format("%s %s", surname, pesel);
    }

    abstract double calculate();

    public String getSurname() {
        return this.surname;
    }

    public String getPesel() {
        return this.pesel;
    }
}
