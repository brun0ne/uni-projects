public class Rysunki {
    static Bryla[] all = new Bryla[20];
    static int n = 0;

    public static void printData(Bryla bryla){
        System.out.println(bryla.toString());

        if (bryla instanceof Prostopadloscian)
            System.out.printf("Objętość: %.2f | Pole: %.2f | Jest sześcianem: %b%n", bryla.volume(), bryla.area(), ((Prostopadloscian) bryla).isCube());
        else if (bryla instanceof Walec)
            System.out.printf("Objętość: %.2f | Pole: %.2f | Z obrotu kwadratu: %b%n", bryla.volume(), bryla.area(), ((Walec) bryla).isRotatedSqr());
    }

    public static void add(Bryla[] to_add){
        for (Bryla bryla : to_add){
            all[n] = bryla;
            n += 1;
        }
    }

    public static void printMaxArea(){
        double max = -1;
        int index = 0;

        for (int i = 0; i < n; i++){
            if (all[i].area() > max){
                max = all[i].area();
                index = i;
            }
        }

        System.out.printf(">> Bryła o największym polu [i=%d]:%n", index);
        printData(all[index]);
    }

    public static void printAll(){
        System.out.println(">> Wszystkie bryły w kolejności występowania: ");

        for (int i = 0; i < n; i++){
            System.out.println(all[i].toString());
        }
    }

    public static void printOnlyPr(){
        System.out.println(">> Tylko prostopadłościany: ");

        for (int i = 0; i < n; i++){
            if (!(all[i] instanceof Prostopadloscian)) // skip everything but Prostopadloscian
                continue;

            System.out.println(all[i].toString());
        }
    }
    public static void printOnlyWal(){
        System.out.println(">> Tylko walce: ");

        for (int i = 0; i < n; i++){
            if (!(all[i] instanceof Walec)) // skip everything but Walec
                continue;

            System.out.println(all[i].toString());
        }
    }

    public static int getCubeCount(){
        int count = 0;

        for (int i = 0; i < n; i++){
            if (!(all[i] instanceof Prostopadloscian)) // skip everything but Prostopadloscian
                continue;

            if ( ((Prostopadloscian) all[i]).isCube() )
                count += 1;
        }

        return count;
    }

    public static int getRotSqrCount(){
        int count = 0;

        for (int i = 0; i < n; i++){
            if (!(all[i] instanceof Walec)) // skip everything but Walec
                continue;

            if ( ((Walec) all[i]).isRotatedSqr() )
                count += 1;
        }

        return count;
    }

    public static void main() {
        Prostopadloscian def_pr = new Prostopadloscian(); // default
        Prostopadloscian pr = new Prostopadloscian("Inny", 2, 3, 4);
        Prostopadloscian cube = new Prostopadloscian("Sześcienny", 4, 4, 4);

        Walec def_walec = new Walec(); // default
        Walec walec = new Walec("Inny", 6, 2);
        Walec sqr_walec = new Walec("Kw", 5, 5);

        add(new Bryla[]{def_pr, def_walec});
        add(new Bryla[]{pr, walec});
        add(new Bryla[]{cube, sqr_walec});

        printMaxArea();
        printAll();

        printOnlyPr();
        printOnlyWal();

        System.out.printf(">> Ile sześcianów: %d%n", getCubeCount());
        System.out.printf(">> Ile walców powstałych z obrotu kwadratu: %d%n", getRotSqrCount());
    }
}
