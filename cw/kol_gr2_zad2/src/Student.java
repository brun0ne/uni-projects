import java.util.ArrayList;
import java.util.Locale;

public class Student {
    private final String name;
    private final String surname;
    private final int index;
    private ArrayList<Double> grades;

    Student(String name, String surname, int index){
        this.name = name;
        this.surname = surname;
        this.index = index;

        this.grades = new ArrayList<>();
    }

    Student(String name, String surname, int index, ArrayList<Double> grades){
        this(name, surname, index);
        this.grades = grades;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public int getIndex() {
        return this.index;
    }

    public ArrayList<Double> getGrades() {
        return this.grades;
    }

    public double average(){
        double summed = 0;

        for (double grade : this.grades){
            summed += grade;
        }

        return summed / this.grades.size();
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "%-15d %-10s %-10s %-3.2f", this.index, this.surname, this.name, this.average());
    }
}
