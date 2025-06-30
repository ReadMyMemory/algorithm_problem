package solved.silver.S2;
import java.io.*;
import java.util.*;

public class S2_16931 {
    static int N, M;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int h = arr[i][j];
                if (h == 0) continue;

                // 윗면, 아랫면
                answer += 2;

                // 4방향
                for (int d = 0; d < 4; d++) {
                    int ni = i + dx[d];
                    int nj = j + dy[d];

                    int neighbor = 0;
                    if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
                        neighbor = arr[ni][nj];
                    }
                    int diff = h - neighbor;
                    if (diff > 0) answer += diff;
                }
            }
        }
        System.out.println(answer);
    }
}
