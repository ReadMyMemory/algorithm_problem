package solved.silver.S3;
import java.io.*;

public class S3_2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // dp[i][j]: i자리 이친수 중 마지막 자리가 j인 개수
        // j = 0: 마지막이 0, j = 1: 마지막이 1
        long[][] dp = new long[N + 1][2];

        // 1자리 이친수: 1만 가능
        dp[1][0] = 0;
        dp[1][1] = 1;

        // 동적 프로그래밍
        for (int i = 2; i <= N; i++) {
            // 마지막이 0인 경우: 이전 자리는 0 또는 1 가능
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];

            // 마지막이 1인 경우: 이전 자리는 반드시 0 (11 방지)
            dp[i][1] = dp[i - 1][0];
        }

        // N자리 이친수의 총 개수
        long answer = dp[N][0] + dp[N][1];

        System.out.println(answer);
    }
}