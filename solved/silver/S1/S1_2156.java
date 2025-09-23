package solved.silver.S1;
import java.io.*;

public class S1_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] wine = new int[n + 1];
        int[] dp = new int[n + 1];

        // 포도주 양 입력
        for (int i = 1; i <= n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        // 기저 사례
        if (n >= 1) {
            dp[1] = wine[1];
        }
        if (n >= 2) {
            dp[2] = wine[1] + wine[2];
        }

        // 1. i번째 잔을 마시지 않는 경우: dp[i-1]
        // 2. i번째 잔을 마시고, i-1번째는 안 마시는 경우: dp[i-2] + wine[i]
        // 3. i번째와 i-1번째를 마시는 경우: dp[i-3] + wine[i-1] + wine[i]
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i-1],
                    Math.max(dp[i-2] + wine[i],
                            dp[i-3] + wine[i-1] + wine[i]));
        }
        System.out.println(dp[n]);
    }
}