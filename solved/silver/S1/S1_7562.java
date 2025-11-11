package solved.silver.S1;
import java.io.*;
import java.util.*;

public class S1_7562 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int[] dr = {-2,-2,-1,-1,1,1,2,2};
        int[] dc = {-1,1,-2,2,-2,2,-1,1};

        while (T-- > 0) {
            int L = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int sr = Integer.parseInt(st.nextToken());
            int sc = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int tr = Integer.parseInt(st.nextToken());
            int tc = Integer.parseInt(st.nextToken());

            if (sr == tr && sc == tc) {
                sb.append(0).append('\n');
                continue;
            }

            boolean[][] visited = new boolean[L][L];
            int[][] dist = new int[L][L];
            Queue<int[]> q = new ArrayDeque<>();

            q.add(new int[]{sr, sc});
            visited[sr][sc] = true;

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int r = cur[0], c = cur[1];

                for (int k = 0; k < 8; k++) {
                    int nr = r + dr[k];
                    int nc = c + dc[k];
                    if (nr < 0 || nr >= L || nc < 0 || nc >= L) continue;
                    if (visited[nr][nc]) continue;

                    visited[nr][nc] = true;
                    dist[nr][nc] = dist[r][c] + 1;

                    if (nr == tr && nc == tc) {
                        q.clear();
                        break;
                    }
                    q.add(new int[]{nr, nc});
                }
            }

            sb.append(dist[tr][tc]).append('\n');
        }

        System.out.print(sb.toString());
    }
}
