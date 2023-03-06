public class Z1_func {
    // zadanie 1

    public static double f_x(double x, double epsilon){ // epsilon = h
        double numerator = 1;
        double denominator = 1;

        double change;
        double result = 0;

        int i = 0;
        do{
            change = numerator / denominator;

            if(i % 4 == 0)
                result += change;
            else
                result -= change;

            i += 2;
            numerator *= x*x;
            denominator *= i*(i-1);
        } while(Math.abs(change) > epsilon);

        return result;
    }

    public static void multiple_f_x(double a, double b, double h){ // [a, b) with h as step
        double x = a;
        final double EPSILON = 0.00001;

        while(x < b){
            System.out.printf("%.2f | ", x);
            System.out.printf("%.4f%n", f_x(x, EPSILON));

            x += h;
        }
    }

    public static void main(){
        // test for one x
        // System.out.println(f_x(3.14/3, 0.00001));
        // System.out.println(f_x(0, 0.00001));
        // System.out.println(f_x(-3.14/3, 0.00001));

        // test for [a, b) with step h
        multiple_f_x(-1, 1, 0.1);
    }
}
