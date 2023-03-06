public class Swapping {
    public static String pairSwapStr(String input){
        return input.replaceAll("\\b([a-zA-Z_][a-zA-Z0-9]*)=([a-zA-Z_][a-zA-Z0-9]*)\\b", "$2=$1");
    }

    public static void pairSwap(String input){
        System.out.println(pairSwapStr(input));
    }
}
