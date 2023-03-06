import java.util.Scanner;

public class Main {
    public static int sum_of_odd(int n, int m){
        if (!(n < m)){
            System.out.println("Wrong data");
            System.exit(1);
        }

        int sum = 0;

        if (n % 2 == 0)
            n += 1;

        for(int i = n; i <= m; i += 2){
            sum += i;
        }

        return sum;
    }
    
    static double numerator(int n){
        double numerator = 0;

        // evaluate numerator
        System.out.printf("Numerator: ");
        System.out.printf("0");
        for (int i = 1; i < n; i++){
            int new_term = (i*3) - 1;

            numerator += new_term;
            System.out.printf(" + %d", new_term);
        }
        System.out.printf("%n");

        return numerator;
    }

    static public double denominator(int n){
        double denominator = 1;

        // evaluate denominator
        System.out.printf("Denominator: ");
        System.out.printf("1");
        for (int i = 1; i < n; i++){
            double new_term = ((i * 4) - 1) * Math.pow(-1, i+1);

            denominator *= new_term;
            System.out.printf(" * %f", new_term);
        }
        System.out.printf("%n");

        return denominator;
    }

    static public double evaluate(int n){
        if (!(n > 0)){
            System.out.println("Wrong data");
            System.exit(0);
        }

        double numerator = numerator(n);
        double denominator = denominator(n);

        return numerator / denominator;
    }

    public static void main(String[] args) {
        System.out.println(sum_of_odd(4, 7));
        System.out.println("------");
        System.out.println(evaluate(5));
    }
}