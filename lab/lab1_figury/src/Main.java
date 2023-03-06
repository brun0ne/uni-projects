import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Figura:");
        String what = scanner.nextLine();

        switch (what){
            case "kwadrat": {
                System.out.println("Długość boku kwadratu:");
                int a = scanner.nextInt();

                Kwadrat kwadrat = new Kwadrat(a);

                System.out.printf("Pole: %d%n", kwadrat.pole());
                System.out.printf("Obwód: %d%n", kwadrat.obwod());
                System.out.printf("Przekątna: %f%n", kwadrat.przekatna());
                break;
            }
            case "prostokat": {
                System.out.println("Długość boku a:");
                int a = scanner.nextInt();

                System.out.println("Długość boku b:");
                int b = scanner.nextInt();

                Prostakat prostakat = new Prostakat(a, b);

                System.out.printf("Pole: %d%n", prostakat.pole());
                System.out.printf("Obwód: %d%n", prostakat.obwod());
                System.out.printf("Przekątna: %f%n", prostakat.przekatna());
                break;
            }
            default:
                System.out.println("Nieznana figura");
        }


    }
}