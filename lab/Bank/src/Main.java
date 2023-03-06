public class Main {
    public static void printAcc(Konto[] konta){
        for(Konto konto : konta){
            System.out.println(konto.getStan());
        }
    }

    public static Konto getMostRich(Konto[] konta){
        Konto most_rich = null;
        double highest = -1;

        for (Konto konto : konta) {
            if (konto.getSaldo() > highest) {
                highest = konto.getSaldo();
                most_rich = konto;
            }
        }

        return most_rich;
    }

    public static void main(String[] args) {
        final int N = 10;
        Konto[] bank = new Konto[N];

        for (int i = 0; i < N; i++){
            bank[i] = new Konto(Konto.rand.nextInt(1000));
        }

        // print all
        System.out.println("Wyśw. wszystko:");
        printAcc(bank);

        // get most rich
        System.out.println("Najwięcej pieniędzy ma:");
        System.out.println(getMostRich(bank).getStan());
    }
}