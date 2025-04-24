package solved.bronze.B2;
import java.io.*;

public class B2_13410 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        int N = Integer.parseInt(parts[0]);
        int K = Integer.parseInt(parts[1]);

        int maxReversed = 0;
        for (int i = 1; i <= K; i++) {
            int product = N * i;
            String reversedStr = new StringBuilder()
                    .append(product)
                    .reverse()
                    .toString();
            int reversed = Integer.parseInt(reversedStr);
            if (reversed > maxReversed) {
                maxReversed = reversed;
            }
        }
        System.out.println(maxReversed);
    }
}
