package solved.silver.S1;
import java.io.*;

public class S1_15993 {
    static final int MOD = 1000000009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // dp[i][0] = i를 1,2,3의 합으로 나타낼 때 짝수 개 사용하는 경우의 수
        // dp[i][1] = i를 1,2,3의 합으로 나타낼 때 홀수 개 사용하는 경우의 수
        long[][] dp = new long[100001][2];

        // 초기값 설정
        dp[1][1] = 1; // 1 = 1 (홀수 개)
        dp[2][0] = 1; // 2 = 1+1 (짝수 개)
        dp[2][1] = 1; // 2 = 2 (홀수 개)
        dp[3][0] = 2; // 3 = 1+1+1, 3 = 1+2 (짝수 개)
        dp[3][1] = 2; // 3 = 1+1+1, 3 = 3 (홀수 개)

        // DP 계산
        for (int i = 4; i <= 100000; i++) {
            // i를 만들기 위해 마지막에 1을 추가하는 경우
            // i-1을 홀수 개로 만들었다면 -> i는 짝수 개
            // i-1을 짝수 개로 만들었다면 -> i는 홀수 개
            dp[i][0] = (dp[i][0] + dp[i-1][1]) % MOD;
            dp[i][1] = (dp[i][1] + dp[i-1][0]) % MOD;

            // i를 만들기 위해 마지막에 2를 추가하는 경우
            if (i >= 2) {
                dp[i][0] = (dp[i][0] + dp[i-2][1]) % MOD;
                dp[i][1] = (dp[i][1] + dp[i-2][0]) % MOD;
            }

            // i를 만들기 위해 마지막에 3을 추가하는 경우
            if (i >= 3) {
                dp[i][0] = (dp[i][0] + dp[i-3][1]) % MOD;
                dp[i][1] = (dp[i][1] + dp[i-3][0]) % MOD;
            }
        }

        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(dp[n][1] + " " + dp[n][0] + "\n");
        }
        bw.flush();
    }
}