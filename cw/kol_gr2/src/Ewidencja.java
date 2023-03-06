import java.util.*;

public class Ewidencja {
    private final HashSet<CD> CDs = new HashSet<>();

    Ewidencja(){

    }

    public HashSet<CD> getCDs() {
        return this.CDs;
    }

    public CD getCDbyID(int ID){
        for (CD cd : this.CDs){
            if (cd.getID() == ID)
                return cd;
        }

        throw new RuntimeException("Błąd w szukaniu płyty (to nigdy nie powinno się wydarzyć)");
    }

    public void display(CD cd){
        display(cd.getUtwory());
    }

    public void display(ArrayList<Utwor> utwory){
        Iterator<Utwor> it = utwory.iterator();
        while (it.hasNext()) {
            Utwor utwor = it.next();

            System.out.printf("%s%n", utwor.toString());
        }
    }

    public void displayListOfKompozytor(ArrayList<Kompozytor> kompozytorzy){
        for (Kompozytor kompozytor : kompozytorzy){
            System.out.printf("%s%n", kompozytor.toString());
        }
    }

    public ArrayList<Utwor> allWithoutDuplicates(){
        HashSet<Utwor> all = new HashSet<>();

        for (CD cd : this.CDs){
            all.addAll(cd.getUtwory());
        }

        return new ArrayList<>(all.stream().toList());
    }

    public ArrayList<Utwor> allAlphabeticalWithoutDuplicates(){
        ArrayList<Utwor> all = this.allWithoutDuplicates();

        return new ArrayList<>(all.stream().sorted(new CustomComparators.UtworAlfabeticComparator()).toList());
    }

    public ArrayList<Utwor> alphabeticalByCD_andKompozytor(int ID, Kompozytor kompozytor){
        return this.alphabeticalByCD_andKompozytor(this.getCDbyID(ID), kompozytor);
    }

    public ArrayList<Utwor> alphabeticalByCD_andKompozytor(CD cd, Kompozytor kompozytor){
        return new ArrayList<>(cd.getUtwory().stream().filter(p -> p.getKompozytor().equals(kompozytor)).sorted(new CustomComparators.UtworAlfabeticComparator()).toList());
    }

    public ArrayList<Utwor> allAlphabeticalByKompozytorWithoutDuplicates(Kompozytor kompozytor){
        ArrayList<Utwor> all = this.allWithoutDuplicates();

        return new ArrayList<>(all.stream().filter(p -> p.getKompozytor().equals(kompozytor)).sorted(new CustomComparators.UtworAlfabeticComparator()).toList());
    }

    public ArrayList<Kompozytor> alphabeticalKompozytorzyOnCD(int ID){
        return this.alphabeticalKompozytorzyOnCD(this.getCDbyID(ID));
    }

    public ArrayList<Kompozytor> alphabeticalKompozytorzyOnCD(CD cd){
        HashSet<Kompozytor> kompozytorzy = new HashSet<>();

        for (Utwor utwor : cd.getUtwory()){
            kompozytorzy.add(utwor.getKompozytor());
        }

        return new ArrayList<>(kompozytorzy.stream().sorted(new CustomComparators.KompozytorAlphabeticComparator()).toList());
    }

    public ArrayList<Kompozytor> allAlphabeticalKompozytorzy(){
        HashSet<Kompozytor> kompozytorzy = new HashSet<>();

        for (Utwor utwor : this.allWithoutDuplicates()){
            kompozytorzy.add(utwor.getKompozytor());
        }

        return new ArrayList<>(kompozytorzy.stream().sorted(new CustomComparators.KompozytorAlphabeticComparator()).toList());
    }

}
