package solved.gold.G5;
import java.io.*;

public class G5_2410 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        final int MOD = 1000000000;

        // dp[i] = i를 2의 멱수의 합으로 나타내는 경우의 수
        int[] dp = new int[n + 1];
        dp[0] = 1; // 0을 만드는 경우의 수는 1 (아무것도 선택하지 않음)

        // 2의 멱수들을 차례대로 사용
        for (int power = 1; power <= n; power *= 2) {
            // power를 사용하여 각 수를 만드는 경우의 수 갱신
            for (int i = power; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - power]) % MOD;
            }
        }
        System.out.println(dp[n]);
    }
}