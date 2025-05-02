package solved.bronze.B1;
import java.io.*;

public class B1_16715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int bestBase = 2;
        int maxSum = 0;

        for (int b = 2; b <= N; b++) {
            int sum = 0;
            int x = N;
            while (x > 0) {
                sum += x % b;
                x /= b;
            }
            if (sum > maxSum) {
                maxSum = sum;
                bestBase = b;
            }
        }
        System.out.println(maxSum + " " + bestBase);
    }
}
