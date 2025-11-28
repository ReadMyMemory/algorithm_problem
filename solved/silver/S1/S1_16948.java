package solved.silver.S1;
import java.io.*;
import java.util.*;

public class S1_16948 {
    // 데스 나이트가 이동할 수 있는 6가지 방향
    static final int[] dr = {-2, -2, 0, 0, 2, 2};
    static final int[] dc = {-1, 1, -2, 2, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine().trim());

        st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        int result = bfs(N, r1, c1, r2, c2);
        System.out.println(result);
    }

    // BFS로 최단 이동 횟수 구하기
    private static int bfs(int N, int sr, int sc, int tr, int tc) {
        // 방문 겸 거리 배열 (미방문은 -1)
        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], -1);
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});
        dist[sr][sc] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            if (r == tr && c == tc) {
                return dist[r][c];
            }

            for (int d = 0; d < 6; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (dist[nr][nc] != -1) continue; // 이미 방문

                dist[nr][nc] = dist[r][c] + 1;
                q.offer(new int[]{nr, nc});
            }
        }
        // 도달 불가능
        return -1;
    }
}
