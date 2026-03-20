package solved.gold.G3;
import java.io.*;
import java.util.*;

public class G3_11062 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] cards = new int[n];
            int sum = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                cards[i] = Integer.parseInt(st.nextToken());
                sum += cards[i];
            }

            int[][] dp = new int[n][n];

            // 길이 1인 구간
            for (int i = 0; i < n; i++) {
                dp[i][i] = cards[i];
            }

            // 길이 2 이상인 구간
            for (int len = 2; len <= n; len++) {
                for (int l = 0; l + len - 1 < n; l++) {
                    int r = l + len - 1;
                    dp[l][r] = Math.max(cards[l] - dp[l + 1][r], cards[r] - dp[l][r - 1]);
                }
            }

            int diff = dp[0][n - 1];
            int geunwoo = (sum + diff) / 2;

            sb.append(geunwoo).append('\n');
        }
        System.out.print(sb);
    }
}