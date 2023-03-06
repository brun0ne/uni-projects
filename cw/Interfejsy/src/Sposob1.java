public class Sposob1 implements SposobNaChoinke{
    public void narysujChoinke(int n){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < i; j++){
                System.out.printf("*");
            }
            System.out.printf("%n");
        }
    }
}
