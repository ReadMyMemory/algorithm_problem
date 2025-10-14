package solved.silver.S1;
import java.io.*;

public class S1_10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        final int MOD = 1000000000;

        // dp[i][j] = 길이가 i이고 마지막 자리 숫자가 j인 계단 수의 개수
        long[][] dp = new long[N + 1][10];

        // 길이가 1인 경우 초기화 (0으로 시작할 수 없음)
        for (int j = 1; j <= 9; j++) {
            dp[1][j] = 1;
        }

        // 동적 프로그래밍
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                // 이전 자리가 j-1이었던 경우
                if (j > 0) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
                // 이전 자리가 j+1이었던 경우
                if (j < 9) {
                    dp[i][j] += dp[i - 1][j + 1];
                }
                dp[i][j] %= MOD;
            }
        }

        // 길이가 N인 모든 계단 수의 합
        long answer = 0;
        for (int j = 0; j <= 9; j++) {
            answer += dp[N][j];
            answer %= MOD;
        }
        System.out.println(answer);
    }
}