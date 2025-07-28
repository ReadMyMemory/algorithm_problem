package solved.silver.S1;
import java.io.*;
import java.util.*;

public class S1_14940 {
    static int n, m;
    static int[][] map;
    static int[][] dist;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dist = new int[n][m];
        visited = new boolean[n][m];

        int startX = 0, startY = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 목표지점 위치 저장
                if (map[i][j] == 2) {
                    startX = i;
                    startY = j;
                }
                // 초기 거리는 -1로 채워둠 (1인 곳만)
                dist[i][j] = -1;
            }
        }

        bfs(startX, startY);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    sb.append(0);
                } else {
                    sb.append(dist[i][j]);
                }
                if (j != m - 1) sb.append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        dist[x][y] = 0; // 시작점 거리는 0

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == 0) continue;
                visited[nx][ny] = true;
                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                q.offer(new int[]{nx, ny});
            }
        }
    }
}
