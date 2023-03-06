public class Main {
    public static void eval1(double a, double b, double c){
        double delta = b*b - 4*a*c;

        if(a == 0 && b == 0 && c == 0){
            System.out.println("tożsamość");
            System.exit(1);
        }
        if(a == 0) {
            System.out.println(-c / b);
            System.exit(1);
        }

        if(delta > 0) {
            System.out.println((-b + Math.sqrt(delta)) / 2*a);
            System.out.println((-b - Math.sqrt(delta)) / 2*a);
        }
        else if(delta == 0){
            System.out.println(-b / 2*a);
        }
        else {
            System.out.println("sprzeczność");
        }
    }

    public static void min_max_digit(int a){
        int max = -1;
        int min = 10;

        while (a > 0){
            int t = a % 10;

            if(t > max)
                max = t;
            if(t < min)
                min = t;

            a /= 10;
        }

        System.out.println("max: " + max);
        System.out.println("min: " + min);
    }

    public static double e_x(double x, double epsilon){
        double res = 1;

        double num = 1;
        double den = 1;

        int i = 1;
        while (num / den > epsilon){
            num *= x;
            den *= i;

            res += num / den;

            i++;
        }

        return res;
    }

    public static long bin_to_dec(long number){
        long res = 0;
        long power = 1;

        while (number > 0){
            long n = number % 10;
            res += n * power;
            number /= 10;

            power *= 2;
        }

        return res;
    }

    public static void br(){
        System.out.println("-----");
    }

    public static void main(String [] args) {
        eval1(1, -4, 3);
        br();
        min_max_digit(2137);
        br();
        System.out.println(e_x(1, 0.0001));
        br();
        System.out.println(bin_to_dec(1101));
    }
}
