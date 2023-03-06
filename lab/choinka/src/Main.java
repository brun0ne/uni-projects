import java.util.Scanner;

public class Main {
    public static int max(int a, int b, int c){
        int got_max = -Integer.MIN_VALUE;

        if (a > got_max) got_max = a;
        if (b > got_max) got_max = b;
        if (c > got_max) got_max = c;

        return got_max;
    }

    public static void draw(int n){
        int line_width = 21;

        for (int i = 0; i < n; i += 2){
            // blank space before
            for(int j = 0; j < (line_width - i) / 2; j++){
                System.out.printf(" ");
            }
            // stars
            for(int j = 0; j < i; j++){
                System.out.printf("*");
            }
            // blank space after
            for(int j = 0; j < (line_width - i) / 2; j++){
                System.out.printf(" ");
            }
            // newline
            System.out.printf("%n");
        }

        // trunk
        int trunk_length = 3;
        for(int i = 0; i < trunk_length; i++){
            // space before
            for(int j = 0; j < line_width / 2; j++){
                System.out.printf(" ");
            }

            System.out.printf("|");

            // space after
            for(int j = 0; j < line_width / 2; j++){
                System.out.printf(" ");
            }

            System.out.printf("%n");
        }
    }

    public static void main(String[] args) {
        System.out.println(max(-100, 100, 50));
        draw(20);
    }
}