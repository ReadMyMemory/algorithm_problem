package solved.gold.G5;
import java.io.*;
import java.util.*;

public class G5_14503 {
    static int N, M;
    static int r, c, d;
    static int[][] a;

    // 0:북, 1:동, 2:남, 3:서
    static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        a = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cleaned = 0;

        while (true) {
            // 1) 현재 칸 청소 (0이면 아직 청소 안함)
            if (a[r][c] == 0) {
                a[r][c] = 2; // 2: 청소 완료 표시
                cleaned++;
            }

            // 2) 왼쪽 방향부터 4방향 탐색
            boolean moved = false;
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4; // 왼쪽 회전
                int nr = r + dr[d];
                int nc = c + dc[d];

                // 청소 안 된 빈 칸(0)이면 전진
                if (a[nr][nc] == 0) {
                    r = nr;
                    c = nc;
                    moved = true;
                    break;
                }
            }

            if (moved) continue;

            // 3) 4방향 모두 불가 -> 후진
            int backDir = (d + 2) % 4;
            int brR = r + dr[backDir];
            int brC = c + dc[backDir];

            // 뒤가 벽(1)이면 종료
            if (a[brR][brC] == 1) break;

            // 뒤가 벽이 아니면 후진 (방향은 유지)
            r = brR;
            c = brC;
        }
        System.out.println(cleaned);
    }
}
