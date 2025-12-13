package solved.silver.S1;
import java.io.*;
import java.util.*;

public class S1_11057 {
    static final int MOD = 10007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int[] dp = new int[10];
        Arrays.fill(dp, 1); // 길이 1: 0~9 각 1개

        for (int len = 2; len <= N; len++) {
            for (int d = 1; d <= 9; d++) {
                dp[d] = (dp[d] + dp[d - 1]) % MOD;
            }
        }

        int ans = 0;
        for (int d = 0; d <= 9; d++) ans = (ans + dp[d]) % MOD;

        System.out.println(ans);
    }
}
