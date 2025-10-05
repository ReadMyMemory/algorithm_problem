package solved.gold.G5;
import java.io.*;
import java.util.*;

public class G5_7576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken()); // 가로
        int N = Integer.parseInt(st.nextToken()); // 세로

        int[][] box = new int[N][M];
        Queue<int[]> queue = new LinkedList<>();
        int unripe = 0; // 익지 않은 토마토 개수

        // 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    queue.offer(new int[]{i, j, 0}); // 행, 열, 날짜
                } else if (box[i][j] == 0) {
                    unripe++;
                }
            }
        }

        // 처음부터 모든 토마토가 익어있는 경우
        if (unripe == 0) {
            System.out.println(0);
            return;
        }

        // BFS
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int maxDays = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int days = current[2];

            maxDays = Math.max(maxDays, days);

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && box[nx][ny] == 0) {
                    box[nx][ny] = 1;
                    unripe--;
                    queue.offer(new int[]{nx, ny, days + 1});
                }
            }
        }

        // 결과 출력
        if (unripe > 0) {
            System.out.println(-1);
        } else {
            System.out.println(maxDays);
        }
    }
}