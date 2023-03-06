public class Wielomian {
    public static double Hermite(double x, double n){
        double H = 1;
        double prev_H = 1;
        double prev_prev_H = 0;

        n += 1;

        for (int i = 1; i < n; i++){
            prev_prev_H = prev_H;
            prev_H = H;

            H = 2*x*H - 2*(i-1)*prev_prev_H;
        }

        return H;
    }
}