import java.util.Arrays;

public class Main {
    public static int getSecondSmallest(int[] array){
        int min_int = Integer.MAX_VALUE - 1;
        int second_min_int = Integer.MAX_VALUE;

        for (int current : array) {
            if (current < min_int) {
                second_min_int = min_int;
                min_int = current;
            }

            if (min_int < current && second_min_int > current)
                second_min_int = current;
        }

        return second_min_int;
    }

    public static int[] nextPascalLine(int[] args){
        int[] new_array = new int[args.length + 1];
        new_array[0] = new_array[new_array.length - 1] = 1;

        for (int i = 1; i < args.length; i++){
            new_array[i] = args[i-1] + args[i];
        }
        return new_array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextPascalLine(new int[]{1, 2, 1})));

        System.out.println(getSecondSmallest(new int[]{1, 4, 6, 8}));

        // todo zad 3
    }
}