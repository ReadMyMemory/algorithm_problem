package solved.silver.S1;
import java.io.*;

public class S1_16723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long sum = 0;

        for (long t = 1; t <= N; t++) {
            long k = t;
            int cnt = 0;
            while (k % 2 == 0) {
                cnt++;
                k /= 2;
            }
            sum += (1L << (cnt + 1));
        }
        System.out.println(sum);
    }
}
