package solved.gold.G5;
import java.io.*;
import java.util.*;

public class G5_1577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        // 공사 중인 도로를 저장할 Set
        Set<String> blocked = new HashSet<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            // (a,b) -> (c,d) 도로가 막혀있음
            // 작은 좌표를 먼저 저장하여 일관성 유지
            if (a < c || (a == c && b < d)) {
                blocked.add(a + "," + b + "," + c + "," + d);
            } else {
                blocked.add(c + "," + d + "," + a + "," + b);
            }
        }

        // dp[i][j] = (0,0)에서 (i,j)까지 가는 경우의 수
        long[][] dp = new long[N + 1][M + 1];
        dp[0][0] = 1;

        // 각 위치까지 도달하는 경우의 수 계산
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                if (i == 0 && j == 0) continue;

                long fromLeft = 0;
                long fromBottom = 0;

                // 왼쪽에서 오는 경우 (i-1, j) -> (i, j)
                if (i > 0) {
                    String road = (i - 1) + "," + j + "," + i + "," + j;
                    if (!blocked.contains(road)) {
                        fromLeft = dp[i - 1][j];
                    }
                }

                // 아래에서 오는 경우 (i, j-1) -> (i, j)
                if (j > 0) {
                    String road = i + "," + (j - 1) + "," + i + "," + j;
                    if (!blocked.contains(road)) {
                        fromBottom = dp[i][j - 1];
                    }
                }
                dp[i][j] = fromLeft + fromBottom;
            }
        }
        System.out.println(dp[N][M]);
    }
}