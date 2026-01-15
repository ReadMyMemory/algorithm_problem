package solved.bronze.B1;
import java.io.*;

public class B1_2775 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        int[][] dp = new int[15][15];

        // 0층 초기화: 0층 n호 = n명
        for (int n = 1; n <= 14; n++) dp[0][n] = n;

        // dp 채우기
        for (int k = 1; k <= 14; k++) {
            dp[k][1] = 1; // k층 1호는 항상 1명
            for (int n = 2; n <= 14; n++) {
                dp[k][n] = dp[k][n - 1] + dp[k - 1][n];
            }
        }

        for (int tc = 0; tc < T; tc++) {
            int k = Integer.parseInt(br.readLine().trim());
            int n = Integer.parseInt(br.readLine().trim());
            sb.append(dp[k][n]).append('\n');
        }

        System.out.print(sb.toString());
    }
}
