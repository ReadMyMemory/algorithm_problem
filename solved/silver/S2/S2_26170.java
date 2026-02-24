package solved.silver.S2;
import java.io.*;
import java.util.*;

public class S2_26170 {
    static final int N = 5;
    static int[][] a = new int[N][N];
    static int ans = Integer.MAX_VALUE;

    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    static void dfs(int r, int c, int eaten, int move) {
        if (move >= ans) return;
        if (eaten == 3) {
            ans = Math.min(ans, move);
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
            if (a[nr][nc] == -1) continue;

            // 떠나는 즉시 현재칸이 장애물로 변함
            int curBackup = a[r][c];
            a[r][c] = -1;

            int nextBackup = a[nr][nc];
            int neaten = eaten;

            // 사과 먹기
            if (a[nr][nc] == 1) {
                neaten++;
                a[nr][nc] = 0;
            }

            dfs(nr, nc, neaten, move + 1);

            // 복구
            a[nr][nc] = nextBackup;
            a[r][c] = curBackup;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        dfs(r, c, 0, 0);

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}