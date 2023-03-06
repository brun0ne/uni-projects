import java.util.Arrays;
import java.util.Random;

public class Pracownik extends Osoba {
    private final String job; // stanowisko
    private final int salary; // pensja (podstawowa)
    private final int rate;   // stawka za nadgodziny
    private final int[] t;    // nadgodziny

    Pracownik(){
        super("", "");

        this.job = "brak";

        this.salary = 0;
        this.rate = 0;

        this.t = null;
    }

    Pracownik(String surname, String pesel, String job, int salary, int rate){
        super(surname, pesel);
        this.job = job;
        this.salary = salary;
        this.rate = rate;

        Random random = new Random();

        this.t = new int[6];
        for (int i = 0; i < 6; i++){
            this.t[i] = random.nextInt(0, 4+1);
        }
    }

    @Override
    public double calculate() {
        int overtime = Arrays.stream(this.t).sum();
        return this.salary + (this.rate * overtime);
    }

    @Override
    public String toString(){
        return String.format("%s [stanowisko=%s, pensja=%s, stawka=%s]", super.toString(), this.job, this.salary, this.rate);
    }

    public void displayOvertime(){ // wyświetla liczbę nadgodzin w poszczególne dni tygodnia
        System.out.println("Nadgodziny w poszczególne dni tygodnia: ");

        String[] days_of_week = new String[]{
                "Poniedziałek",
                "Wtorek",
                "Środa",
                "Czwartek",
                "Piątek",
                "Sobota"
        };

        for(int i = 0; i < 6; i++){
            System.out.printf("-- %s: %d%n", days_of_week[i], this.t[i]);
        }
    }

    public boolean isLibrarian(){
        return this.job.toLowerCase().equals("bibliotekarz");
    }
}
