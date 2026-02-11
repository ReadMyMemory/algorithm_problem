package solved.bronze.B2;
import java.io.*;

public class B2_2231 {
    private static int digitSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += (x % 10);
            x /= 10;
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int digits = String.valueOf(N).length();
        int start = Math.max(1, N - 9 * digits);

        int answer = 0;
        for (int m = start; m <= N; m++) {
            int decomposed = m + digitSum(m);
            if (decomposed == N) {
                answer = m;
                break;
            }
        }
        System.out.println(answer);
    }
}
