package solved.silver.S1;
import java.io.*;
import java.util.*;

public class S1_28471 {
    static int N;
    static char[][] board;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    // Q, W, E, A, D, Z, X, C
    // W(인덱스 1)는 사용 불가
    static boolean[] canUse = {true, false, true, true, true, true, true, true};
    static int fx, fy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'F') {
                    fx = i;
                    fy = j;
                }
            }
        }

        // F에서 역방향 BFS로 도달 가능한 모든 위치 찾기
        boolean[][] reachable = bfsFromGoal();

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == '.' && reachable[i][j]) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    static boolean[][] bfsFromGoal() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        queue.offer(new int[]{fx, fy});
        visited[fx][fy] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            // 역방향으로 이동 (dx, dy의 부호를 반대로)
            for (int i = 0; i < 8; i++) {
                if (!canUse[i]) continue;

                int nx = x - dx[i];
                int ny = y - dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    if (board[nx][ny] == '.') {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        return visited;
    }
}