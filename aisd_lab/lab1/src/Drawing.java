import java.util.ArrayList;

public class Drawing {
    public static ArrayList<String> getPyramid(int n, int h){
        ArrayList<String> result = new ArrayList<>();

        int start = 2*n + 1;

        for (int i = 0; i < h; i++){
            String buffer = " ".repeat(h-1-i);
            String line = "X".repeat(start+i*2);

            result.add(String.format("%s%s", buffer, line));
        }

        return result;
    }

    public static void drawPyramid(int n, int h){
        ArrayList<String> lines = getPyramid(n, h);

        for(String line : lines){
            System.out.println(line);
        }
    }

    public static void drawAFigure(int n){
        for(int i = 0; i < n; i++){
            drawPyramid(i, n-i);
        }
    }
}
