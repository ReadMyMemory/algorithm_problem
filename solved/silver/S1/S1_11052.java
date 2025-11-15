package solved.silver.S1;
import java.io.*;
import java.util.*;

public class S1_11052 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());          // 살 카드 개수
        int[] price = new int[N + 1];                     // price[i] = i개 들어있는 카드팩 가격
        int[] dp = new int[N + 1];                        // dp[i] = i개를 사기 위한 최대 비용

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        // i개를 사는 최대 비용 계산
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + price[j]);
            }
        }
        System.out.println(dp[N]);
    }
}
