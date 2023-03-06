public class Biblioteka {
    public static Osoba[] people = new Osoba[20];
    public static int n = 0;

    public static void addPerson(Osoba person){
        if (n >= 20){
            System.out.println("Tablica osób jest pełna :(");
            return;
        }

        people[n] = person;
        n++;
    }

    public static void displayAll(){
        for (int i = 0; i < n; i++){
            System.out.println(people[i].toString());
        }
    }

    public static void main(){
        // książki
        Ksiazka Pan_Tadeusz = new Ksiazka(0, 1.5f, true);
        Ksiazka Lalka = new Ksiazka(1, 2.5f, false);
        Ksiazka Wesele = new Ksiazka(2, 2.0f, false);
        Ksiazka Chlopi = new Ksiazka(3, 100.0f, false);
        Ksiazka Tango = new Ksiazka(4, 5.5f, false);
        Ksiazka Dziady = new Ksiazka(5, 0.0f, true);

        addPerson(new Czytelnik("Jan", "Kowalski", new Ksiazka[]{Pan_Tadeusz}));
        addPerson(new Czytelnik("Niejan", "Owalski", new Ksiazka[]{Lalka, Wesele}));
        addPerson(new Pracownik("Bob", "Budowniczy", "budowniczy", 1500, 20));
        addPerson(new Pracownik("Pan", "Kałamaż", "bibliotekarz", 2000, 25));
        addPerson(new Czytelnik("Spóźniony", "Marek", new Ksiazka[]{Tango, Chlopi, Dziady}));

        // wyświetlić wszystkich
        System.out.println("------- Wyświetlić wszystkich --------");
        displayAll();

        // wyświetlić samych pracowników i ich nadgodziny
        System.out.println();
        System.out.println("------- Wyświetlić pracowników  --------");

        for (int i = 0; i < n; i++){
            if(!(people[i] instanceof Pracownik))
                continue;

            System.out.println(people[i].toString());
            ((Pracownik) people[i]).displayOvertime();
        }

        // wyświetlić samych czytelników i ich wypożyczenia
        System.out.println();
        System.out.println("------- Wyświetlić czytelników --------");

        for (int i = 0; i < n; i++){
            if(!(people[i] instanceof Czytelnik))
                continue;

            System.out.println(people[i].toString());
            ((Czytelnik) people[i]).displayBooks();
        }

        // policzyć bibliotekarzy
        System.out.println();
        System.out.println("------- Policzyć bibliotekarzy --------");

        int count = 0;
        for (int i = 0; i < n; i++){
            if(!(people[i] instanceof Pracownik))
                continue;

            if (((Pracownik) people[i]).isLibrarian())
                count++;
        }
        System.out.printf("Liczba bibliotekarzy: %d%n", count);

        // który z pracowników najwięcej zarobił?
        System.out.println();
        System.out.println("------- Kto najwięcej zarobił --------");

        double max = 0;
        Osoba bogacz = null;

        for (int i = 0; i < n; i++){
            if(!(people[i] instanceof Pracownik))
                continue;

            if(people[i].calculate() > max){
                max = people[i].calculate();
                bogacz = people[i];
            }
        }

        assert bogacz != null;
        System.out.printf("Najwięcej (%.2f) zarobił: %s", max, bogacz.toString());
    }
}
