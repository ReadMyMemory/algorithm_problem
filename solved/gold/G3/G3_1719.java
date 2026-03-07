package solved.gold.G3;
import java.io.*;
import java.util.*;

public class G3_1719 {
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] dist = new int[n + 1][n + 1];
        int[][] next = new int[n + 1][n + 1];

        // 초기화
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        // 간선 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 같은 두 정점 사이에 여러 간선이 있을 수도 있으니 더 짧은 것만 반영
            if (c < dist[a][b]) {
                dist[a][b] = c;
                dist[b][a] = c;
                next[a][b] = b;
                next[b][a] = a;
            }
        }

        // 플로이드-워셜
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if (i == k) continue;
                for (int j = 1; j <= n; j++) {
                    if (i == j || j == k) continue;
                    if (dist[i][k] == INF || dist[k][j] == INF) continue;

                    int newDist = dist[i][k] + dist[k][j];
                    if (newDist < dist[i][j]) {
                        dist[i][j] = newDist;
                        next[i][j] = next[i][k];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    sb.append("- ");
                } else {
                    sb.append(next[i][j]).append(' ');
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}