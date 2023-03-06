public class Main {
    public static int[][] create_array(int n){
        int[][] arr = new int[n][];

        int num = 1;
        for (int i = 1; i <= arr.length; i++){
            arr[i-1] = new int[i];

            for (int j = 0; j < arr[i-1].length; j++){
                arr[i-1][j] = num;
                num++;
            }
        }

        return arr;
    }

    public static void display_array(int[][] arr){
        for (int[] row : arr){
            for (int col : row){
                System.out.printf("%3d ", col);
            }
            System.out.printf("%n");
        }
    }

    public static void main(String[] args) {
        int n = 30;
        int[][] arr = create_array(n);

        display_array(arr);
    }
}