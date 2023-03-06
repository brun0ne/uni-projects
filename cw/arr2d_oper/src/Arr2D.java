import java.util.Random;

public class Arr2D {
    private final int[][] arr;

    Arr2D(int y, int x){
        this.arr = new int[y][x];
    }

    Arr2D(int y, int x, int max){
        this(y, x);

        Random rand = new Random();

        for(int[] row : this.arr){
            for(int i = 0 ; i < row.length; i++){
                row[i] = rand.nextInt(max+1);
            }
        }
    }

    public void print(){
        for (int[] row : this.arr){
            for (int num : row){
                System.out.printf("%4d ", num);
            }
            System.out.printf("%n");
        }
    }


    public int[] max(){
        int MAX = Integer.MIN_VALUE;
        int pos_x = 0, pos_y = 0;
        int i = 0, j = 0;

        for (int[] row : this.arr){
            for (int num : row){
                if (num > MAX) {
                    MAX = num;
                    pos_x = j;
                    pos_y = i;
                }
                j++;
            }
            i++;
        }
        return new int[]{MAX, pos_x, pos_y};
    }
}
