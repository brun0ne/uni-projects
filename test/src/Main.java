import java.util.Scanner;

public class Main {


    private static void add(Scanner scanner){
        System.out.println("First number: ");
        int num1 = scanner.nextInt();

        System.out.println("Second number: ");
        int num2 = scanner.nextInt();

        int res = num1 + num2;

        System.out.printf("Result: %d%n", res);

        scanner.nextLine();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to The Best App. What would you like to do?");
        System.out.printf("- add%n- subtract%n- exit%n");

        while(true){
            String command = scanner.nextLine();

            switch (command){
                case "add":
                    add(scanner);
                    break;
                case "subtract":
                    System.out.println("subtract");
                    break;
                case "exit":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Unknown command :(");
            }
        }
    }
}