import java.util.Random;

public class Main {
    public static void print_all(int[] arr){
        System.out.print("Wszystkie elementy: [ ");

        for (int i = 0; i < arr.length; i++){
            System.out.printf("%d", arr[i]);

            if (i != arr.length-1)
                System.out.print(", ");
        }

        System.out.printf(" ]%n");
    }

    public static int find_min(int [] arr){
        int min_val = Integer.MAX_VALUE;

        for (int el : arr) {
            if (el < min_val)
                min_val = el;
        }

        return min_val;
    }

    public static long find_product_of_odd(int[] arr){
        long prod = 1;

        for (int el : arr){
            if (el % 2 == 0)
                continue;

            prod *= el;
        }

        return prod;
    }

    public static int count_odd_numbers(int[] arr){
        int count = 0;

        for (int el : arr){
            if (el % 2 == 0)
                continue;

            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 10;
        int[] rand = new int[n];

        Random g = new Random();

        for (int i = 0; i < n; i++){
            rand[i] = g.nextInt(50); // 0 -- 49
        }

        // print all
        print_all(rand);

        // find min
        System.out.printf("Najmniejsza liczba: %d%n", find_min(rand));

        // find product of odd
        System.out.printf("Iloczyn liczb nieparzystych: %d%n", find_product_of_odd(rand));

        // find odd num count
        System.out.printf("Liczba liczb nieparzystych: %d%n", count_odd_numbers(rand));
    }
}