package solved.silver.S1;
import java.io.*;
import java.util.*;

public class S1_2468 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    static void bfs(int sr, int sc, int h) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        visited[sr][sc] = true;
        q.add(new int[]{sr, sc});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (visited[nr][nc]) continue;
                if (map[nr][nc] <= h) continue; // 잠김

                visited[nr][nc] = true;
                q.add(new int[]{nr, nc});
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        map = new int[N][N];

        int maxH = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > maxH) maxH = map[i][j];
            }
        }

        int answer = 1; // 비가 아예 안 오면(=h=0 기준) 최소 1개 가능, 문제에서도 보통 1로 시작해도 안전
        for (int h = 0; h < maxH; h++) {
            visited = new boolean[N][N];
            int count = 0;

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (!visited[r][c] && map[r][c] > h) {
                        count++;
                        bfs(r, c, h);
                    }
                }
            }
            if (count > answer) answer = count;
        }

        System.out.println(answer);
    }
}
