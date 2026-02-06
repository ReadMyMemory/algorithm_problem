package solved.bronze.B2;
import java.io.*;

public class B2_2292 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine().trim());

        long end = 1;
        int layer = 1;

        while (n > end) {
            end += 6L * layer;
            layer++;
        }
        System.out.println(layer);
    }
}