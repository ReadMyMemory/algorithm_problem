package solved.silver.S1;
import java.io.*;
import java.util.*;

public class S1_1926 {
    static int n, m;
    static int[][] a;
    static boolean[][] vis;

    // 상, 하, 좌, 우
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n][m];
        vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int pictureCount = 0;  // 그림 개수(연결 컴포넌트 수)
        int maxArea = 0;       // 가장 넓은 그림의 넓이

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                // 아직 방문 안 했고, 그림(1)인 칸이면 BFS 시작
                if (!vis[r][c] && a[r][c] == 1) {
                    pictureCount++;
                    int area = bfs(r, c);
                    if (area > maxArea) maxArea = area;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(pictureCount).append('\n');
        sb.append(maxArea).append('\n');
        System.out.print(sb);
    }

    // (sr, sc)에서 시작하는 그림 하나의 넓이를 BFS로 계산
    static int bfs(int sr, int sc) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sr, sc});
        vis[sr][sc] = true;

        int area = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                // 범위 체크
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;

                // 방문 안 했고, 그림(1)인 칸만 확장
                if (!vis[nr][nc] && a[nr][nc] == 1) {
                    vis[nr][nc] = true;
                    area++;
                    q.add(new int[]{nr, nc});
                }
            }
        }
        return area;
    }
}
