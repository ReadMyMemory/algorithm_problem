package solved.gold.G4;
import java.io.*;
import java.util.*;

public class G4_11404 {
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // 도시 개수
        int m = Integer.parseInt(br.readLine()); // 버스 개수

        int[][] dist = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0; // 자기 자신으로 가는 비용은 0
        }

        // 간선 입력
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 출발 도시
            int b = Integer.parseInt(st.nextToken()); // 도착 도시
            int c = Integer.parseInt(st.nextToken()); // 비용

            // 같은 구간에 여러 버스가 있을 수 있으므로 최소 비용만 저장
            if (c < dist[a][b]) {
                dist[a][b] = c;
            }
        }

        // 플로이드-워셜 알고리즘
        for (int k = 1; k <= n; k++) {          // 거쳐가는 도시
            for (int i = 1; i <= n; i++) {      // 출발 도시
                for (int j = 1; j <= n; j++) {  // 도착 도시
                    if (dist[i][k] == INF || dist[k][j] == INF) continue;
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // 출력 (갈 수 없으면 0)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == INF) {
                    sb.append(0);
                } else {
                    sb.append(dist[i][j]);
                }
                if (j < n) sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
