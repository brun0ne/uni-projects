import java.util.Random;

public class Z2_2d {
    private int[][] array;

    // static variables
    static Random rand = new Random();

    Z2_2d(int rows){
        this.array = new int[rows][];

        for(int i = 0; i < rows; i++){
            this.array[i] = new int[rand.nextInt(3, 10)];
        }
    }

    public void fillWithRandFromRange(int range){ // [0, range]
        for(int[] row : this.array){
            for(int i = 0; i < row.length; i++){
                row[i] = rand.nextInt(0, range+1);
            }
        }
    }

    public void print(){
        System.out.println("Print: ");
        for(int[] row : this.array){
            for(int val : row){
                System.out.printf("%3d ", val);
            }
            System.out.println();
        }
    }

    public int getLargestRow(){
        int largest = 0;
        for(int[] row : this.array){
            if(row.length > largest)
                largest = row.length;
        }
        return largest;
    }

    public int[][] getRect(){
        int[][] rect = new int[this.array.length][this.getLargestRow()];

        for(int i = 0; i < rect.length; i++){
            for(int j = 0; j < rect[i].length; j++){
                if(j >= this.array[i].length)
                    rect[i][j] = -1;
                else
                    rect[i][j] = this.array[i][j];
            }
        }

        return rect;
    }

    public void printRect(int[][] rect){
        System.out.println("Print rect (col<->row):");
        for(int i = 0; i < rect[0].length; i++){
            for(int j = 0; j < rect.length; j++){
                System.out.printf("%3d", rect[j][i]);
            }
            System.out.printf("%n");
        }
    }

    public static void main(){
        Z2_2d test_array = new Z2_2d(3);
        test_array.print();
        test_array.fillWithRandFromRange(20);
        test_array.print();
        test_array.printRect(test_array.getRect());
    }
}
