public class Main {
    public static double func(int n, double x){
        if(x < 0){
            return 2;
        }
        else if(x <= 2){
            return Math.cos(x) + x;
        }
        else {
            double res = 0;
            double num = 1;

            for(int i = 1; i <= n; i++){
                num *= x;
                res += num / i;
            }

            return res;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        double x = 4;

        System.out.println(func(n, x));
    }
}