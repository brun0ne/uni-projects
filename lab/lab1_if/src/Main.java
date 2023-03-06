import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int a;
        int b;
        Scanner scanner = new Scanner(System.in);

        System.out.println("a: ");
        a = scanner.nextInt();
        System.out.println("b: ");
        b = scanner.nextInt();

        double res;
        if (a >= b){
            res = 2*a + Math.abs(b) - 1;
        }
        else{
            res = Math.sin(a) - b*b;
        }

        System.out.printf("Result: %f%n", res);
    }
}