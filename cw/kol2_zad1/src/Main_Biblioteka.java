public class Main_Biblioteka {
    public static void main(String[] args) {
        // kilka przykladowych autorow
        Autor mickiewicz = new Autor("Adam", "Mickiewicz");
        Autor jas = new Autor("Jas", "Jasiowski");
        Autor mikolaj = new Autor("Mikolaj", "Swiety");

        // kilka przykladowych ksiazek
        Book dziady = new Book(mickiewicz, "Dziady", "Lektury", 1895);
        Book panTadeusz = new Book(mickiewicz, "Pan Tadeusz", "Lektury", 1860);
        Book pierwsza = new Book(jas, "Moja Pierwsza Ksiazka", "Nikt", 2050);
        Book druga = new Book(jas, "Moja Druga Ksiazka", "Dalej Nikt", 2050);
        Book bajka = new Book(mikolaj, "Bajka", "Bajki", 2003);
        Book bajka2 = new Book(jas, "Bajka", "InneBajki", 2002);

        Ewidencja ewidencja = new Ewidencja();

        ewidencja.addBook(dziady);
        ewidencja.addBook(panTadeusz);
        ewidencja.addBook(pierwsza);
        ewidencja.addBook(druga);
        ewidencja.addBook(bajka);
        ewidencja.addBook(bajka2);

        //// wysw alfabetyczne wg tytulow wszystkich ksiazek (bez powtorzen)
        System.out.println("---- Wysw alfabetyczne wg tytulow wszystkich ksiazek (bez powtorzen):");
        ewidencja.displayBooks(ewidencja.allWithoutDuplicatesAlphabeticalByTitle());
        System.out.println();

        //// wysw alfabetyczne wg autorow i tytulow wszystkich ksiazek (bez powtorzen)
        System.out.println("---- Wysw alfabetyczne wg autorow i tytulow wszystkich ksiazek (bez powtorzen):");
        System.out.println("---- (po nazwisku, gdy takie same: po imieniu, gdy takie same: po tytule)");
        ewidencja.displayBooks(ewidencja.allWithoutDuplicatesAlphabeticalByAuthor());
        System.out.println();

        //// wysw alfabetyczne wg tytulow ksiazek wskazanego autora (bez powtorzen)
        System.out.println("---- Wysw alfabetyczne wg tytulow ksiazek Mickiewicza (bez powtorzen):");
        ewidencja.displayBooks(ewidencja.withoutDuplicatesAlphabeticalByTitleOnlyBy(mickiewicz));
        System.out.println();

        //// wysw alfabetyczne wszystkich autorow (bez powtorzen)
        System.out.println("---- Wysw alfabetyczne wszystkich autorow (bez powtorzen):");
        System.out.println("---- (po nazwisku, gdy takie same: po imieniu)");
        ewidencja.displayAuthors(ewidencja.getAllAuthorsAlphabetical());
        System.out.println();

        //// wysw wszystkich ksiazek wskazanego wydawnictwa wg roku wydania (od najnowszych)
        System.out.println("---- Wysw wszystkich ksiazek wydawnictwa Lektury wg roku wydania (od najnowszych):");
        ewidencja.displayBooks(ewidencja.getAllByWydawnictwoFromNewest("Lektury"));
    }
}