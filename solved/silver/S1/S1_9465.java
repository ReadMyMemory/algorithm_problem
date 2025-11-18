package solved.silver.S1;
import java.io.*;
import java.util.*;

public class S1_9465 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[][] stickers = new int[2][n + 1]; // 1-based index 사용

            // 0번째 줄
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                stickers[0][i] = Integer.parseInt(st.nextToken());
            }

            // 1번째 줄
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                stickers[1][i] = Integer.parseInt(st.nextToken());
            }

            // dp[0][i] : i번째 열에서 위 스티커 선택한 경우
            // dp[1][i] : i번째 열에서 아래 스티커 선택한 경우
            // dp[2][i] : i번째 열에서 아무 것도 선택하지 않은 경우
            int[][] dp = new int[3][n + 1];

            for (int i = 1; i <= n; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[2][i - 1]) + stickers[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[2][i - 1]) + stickers[1][i];
                dp[2][i] = Math.max(dp[0][i - 1], Math.max(dp[1][i - 1], dp[2][i - 1]));
            }

            int result = Math.max(dp[0][n], Math.max(dp[1][n], dp[2][n]));
            sb.append(result).append('\n');
        }
        System.out.print(sb.toString());
    }
}
