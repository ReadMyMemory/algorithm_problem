package solved.gold.G4;
import java.io.*;
import java.util.*;

public class G4_2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());  // 동전 종류의 개수
        int k = Integer.parseInt(st.nextToken());  // 목표 금액

        int[] coins = new int[n];  // 동전 가치 배열
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        // dp[i] = i원을 만드는 경우의 수
        int[] dp = new int[k + 1];
        dp[0] = 1;  // 0원을 만드는 경우의 수는 1 (아무것도 선택하지 않는 경우)

        // 각 동전에 대해
        for (int i = 0; i < n; i++) {
            int coin = coins[i];
            // 현재 동전으로 만들 수 있는 금액들을 업데이트
            for (int j = coin; j <= k; j++) {
                dp[j] += dp[j - coin];
            }
        }
        System.out.println(dp[k]);
    }
}