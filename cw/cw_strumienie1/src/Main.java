import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        String data = "";
        int sum = 0;

        do {
            try {
                data = br.readLine();
                if (!data.equals("")) {
                    String[] num_strs = data.split("\\s+");
                    for (String num_str : num_strs){
                        sum += Integer.parseInt(num_str);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } while (!data.equals(""));

        System.out.println(sum);
    }
}