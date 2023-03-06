import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Test czasu wykonania metod z wyjątkami (time in nanoseconds)");

        System.out.println("--- ArithmeticException (dzielenie przez 0) ---");
        Test arithmetic = new ArithmeticExceptionTest();
        test(arithmetic, 100);
        test(arithmetic, 1000);
        test(arithmetic, 10000);
        test(arithmetic, 1000000);

        System.out.println("--- ArrayIndexOutOfBoundsException ---");
        Test outOfBounds = new OutOfBoundsExceptionTest();
        test(outOfBounds, 100);
        test(outOfBounds, 1000);
        test(outOfBounds, 10000);
        test(outOfBounds, 1000000);
    }

    public static void test(Test TestSample, int N){
        long pre, after, avg;

        System.out.println("1. try-catch");

        avg = 0;
        for (int i = 0; i < N; i++) {
            pre = System.nanoTime();
            TestSample.generateAndCatch();
            after = System.nanoTime();

            avg += (after-pre);
        }
        avg /= N;

        System.out.printf("Time average (for N=%d): %d%n", N, avg);

        System.out.println("2. catch outside (throws)");

        avg = 0;
        for (int i = 0; i < N; i++) {
            pre = System.nanoTime();
            try {
                TestSample.generateAndThrow();
            } catch (Exception e) {
                // e.printStackTrace();
            }
            after = System.nanoTime();

            avg += (after-pre);
        }
        avg /= N;

        System.out.printf("Time average (for N=%d): %d%n", N, avg);
    }
}