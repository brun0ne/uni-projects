import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a;
        int b;

        System.out.println("a: ");
        a = scanner.nextInt();
        System.out.println("b: ");
        b = scanner.nextInt();

        //System.out.printf("Wyniki:%na    =%5d%nb    =%5d%n-----------%nsuma =%5d", a, b, a+b);

        System.out.printf("Wyniki:%n");
        System.out.printf("%-4s %s %8d %n", "a", "=", a);
        System.out.printf("%-4s %s %8d %n", "b", "=", b);
        System.out.printf("---------------%n");
        System.out.printf("%s %8d %n", "suma =", a+b);
    }
}