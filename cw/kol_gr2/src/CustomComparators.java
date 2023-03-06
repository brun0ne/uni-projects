import java.util.Comparator;

public class CustomComparators {
    public static class UtworAlfabeticComparator implements Comparator<Utwor> {
        @Override
        public int compare(Utwor o1, Utwor o2) {
            return o1.getTitle().compareTo(o2.getTitle());
        }
    }

    public static class KompozytorAlphabeticComparator implements Comparator<Kompozytor>{

        @Override
        public int compare(Kompozytor o1, Kompozytor o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }
}
