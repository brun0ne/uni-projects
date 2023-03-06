public class OutOfBoundsExceptionTest implements Test {
    public void generateAndCatch(){
        try {
            int[] arr = new int[]{1, 2, 3};

            int y = arr[5]; // out of bounds
        }
        catch(Exception e){
           // e.printStackTrace();
        }
    }

    public void generateAndThrow() throws ArrayIndexOutOfBoundsException{
        int[] arr = new int[]{1, 2, 3};

        int y = arr[5]; // out of bounds
    }
}
