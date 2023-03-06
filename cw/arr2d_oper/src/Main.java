import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Arr2D arr2D = new Arr2D(5, 10, 100);

        arr2D.print();
        System.out.println(Arrays.toString(arr2D.max()));
    }
}