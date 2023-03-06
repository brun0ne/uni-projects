import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Samochody {
    private final ArrayList<Auto> auta;

    Samochody(){
        this.auta = new ArrayList<>();
    }

    void dodajAuto(Auto auto){
        this.auta.add(auto);
    }

    void dodajAuto(Auto[] auta){
        this.auta.addAll(Arrays.asList(auta));
    }

    void print(ArrayList<Auto> auta){
        int i = 1;
        for (Auto auto : auta){
            System.out.printf("%d. %s%n", i, auto.toString());
            i++;
        }

        if(auta.size() == 0)
            System.out.println("<brak>");
    }

    void printAll(){
        this.print(this.auta);
    }

    /////// komparatory

    private static class MarkaComparator implements Comparator<Auto> {
        @Override
        public int compare(Auto o1, Auto o2) {
            return o1.getMarka().compareTo(o2.getMarka());
        }
    }

    private static class LKComparator implements Comparator<Auto> {
        @Override
        public int compare(Auto o1, Auto o2) {
            return Integer.compare(o1.getLk(), o2.getLk());
        }
    }

    private static class MarkaLKComparator implements Comparator<Auto> {
        @Override
        public int compare(Auto o1, Auto o2) {
            if (! o1.getMarka().equals(o2.getMarka()))
                return new MarkaComparator().compare(o1, o2);

            return new LKComparator().compare(o1, o2);
        }
    }

    /////// sortowanie

    public void sortByMarka(){
        this.auta.sort(new MarkaComparator());
    }

    public void sortByLK(){
        this.auta.sort(new LKComparator());
    }

    public void sortByMarkaThenLK(){
        this.auta.sort(new MarkaLKComparator());
    }

    ////// filtrowanie

    public void printAutoWithLargestZuzycie(){
        if (this.auta.size() == 0){
            System.out.println("<brak aut>");
            return;
        }

        Auto auto = this.auta.stream().sorted(Comparator.comparing(Auto::getZuzycie).reversed()).toList().get(0);
        System.out.println(auto.toString());

        int index = this.auta.indexOf(auto);
        System.out.printf(">> Pozycja (z aktualnym sortowaniem): %d%n", index+1);
    }
}
