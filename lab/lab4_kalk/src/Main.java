public class Main {
    public static double calc(double num1, double num2, char operation){
        double res = 0;

        switch (operation) {
            case '+' -> res = num1 + num2;
            case '-' -> res = num1 - num2;
            case '*' -> res = num1 * num2;
            case '/' -> {
                if (num2 == 0) {
                    System.out.println("Division by 0");
                    System.exit(1);
                }
                res = num1 / num2;
            }
            default -> {
                System.out.println("Wrong operation");
                System.exit(1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        char operation = '+';

        double num1 = 4;
        double num2 = 2;

        System.out.println(calc(num1, num2, operation));
    }
}