package solved.gold.G5;
import java.io.*;
import java.util.*;

public class G5_7569 {
    static int M, N, H;
    static int[][][] box;
    static int[][][] dist;

    // 상, 하, 앞, 뒤, 좌, 우 (z, y, x 순서)
    static int[] dz = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dx = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로(열)
        N = Integer.parseInt(st.nextToken()); // 세로(행)
        H = Integer.parseInt(st.nextToken()); // 높이(층)

        box = new int[H][N][M];
        dist = new int[H][N][M];

        ArrayDeque<int[]> q = new ArrayDeque<>();

        // 입력 받으면서 초기 익은 토마토 큐에 넣기
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    box[h][n][m] = Integer.parseInt(st.nextToken());
                    dist[h][n][m] = -1; // 방문 안 함 표시

                    if (box[h][n][m] == 1) {
                        q.offer(new int[]{h, n, m});
                        dist[h][n][m] = 0; // 처음부터 익은 토마토는 0일
                    }
                }
            }
        }

        // BFS
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int z = cur[0];
            int y = cur[1];
            int x = cur[2];

            for (int dir = 0; dir < 6; dir++) {
                int nz = z + dz[dir];
                int ny = y + dy[dir];
                int nx = x + dx[dir];

                if (nz < 0 || nz >= H || ny < 0 || ny >= N || nx < 0 || nx >= M) {
                    continue;
                }

                // 익지 않은 토마토(0)만 익게 만들 수 있음
                if (box[nz][ny][nx] == 0 && dist[nz][ny][nx] == -1) {
                    box[nz][ny][nx] = 1; // 익음 처리
                    dist[nz][ny][nx] = dist[z][y][x] + 1;
                    q.offer(new int[]{nz, ny, nx});
                }
            }
        }

        int answer = 0;

        // 결과 확인
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    // 안 익은 토마토가 남아있으면 -1
                    if (box[h][n][m] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    // 최대 날짜 계산
                    if (dist[h][n][m] > answer) {
                        answer = dist[h][n][m];
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
