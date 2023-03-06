public class ArithmeticExceptionTest implements Test{
    public void generateAndCatch(){
        try {
            int x = 5 / 0;
        }
        catch(Exception e){
            // e.printStackTrace();
        }
    }

    public void generateAndThrow() throws ArithmeticException{
        int x = 5 / 0;
    }
}
