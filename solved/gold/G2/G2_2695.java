package solved.gold.G2;
import java.io.*;
import java.util.*;

public class G2_2695 {

    public static void main(String[] args) throws Exception {
        final int MAX_B = 50;   // 공의 최대 개수
        final int MAX_M = 1000; // 층 수 최대
        final int MAX_K = 1000; // 시도 횟수는 최대 층 수보다 클 수 없음

        // dp[b][k] = 공 b개, 시도 k번일 때 검사할 수 있는 최대 층 수
        int[][] dp = new int[MAX_B + 1][MAX_K + 1];

        for (int k = 1; k <= MAX_K; k++) {
            for (int b = 1; b <= MAX_B; b++) {
                long val = (long) dp[b][k - 1] + dp[b - 1][k - 1] + 1;
                if (val > MAX_M) val = MAX_M; // 1000층까지만 필요하므로 캡
                dp[b][k] = (int) val;
            }
        }

        // ans[b][m] = 공 b개, m층 건물일 때(최악의 경우에도) 필요한 최소 시도 횟수
        int[][] ans = new int[MAX_B + 1][MAX_M + 1];

        for (int b = 1; b <= MAX_B; b++) {
            int floor = 1;
            for (int k = 1; k <= MAX_K && floor <= MAX_M; k++) {
                int cover = dp[b][k];
                while (floor <= MAX_M && cover >= floor) {
                    ans[b][floor] = k;
                    floor++;
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int P = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < P; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int B = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            sb.append(ans[B][M]).append('\n');
        }
        System.out.print(sb.toString());
    }
}
