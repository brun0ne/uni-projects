import java.util.Comparator;

public class CustomComparators {
    public static class StudentComparatorA implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return Double.compare(o2.average(), o1.average());
        }
    }
}
