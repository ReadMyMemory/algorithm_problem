package solved.bronze.B2;
import java.io.*;

public class B2_20494 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long total = 0;
        for (int i = 0; i < N; i++) {
            String line = br.readLine().trim();
            total += line.length();
        }
        System.out.println(total);
    }
}
