package solved.silver.S1;
import java.io.*;
import java.util.*;

public class S1_31946 {
    static int N, M, X;
    static int[][] board;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        board = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        X = Integer.parseInt(br.readLine());

        // 시작점과 도착점의 색이 다르면 불가능
        if (board[0][0] != board[N-1][M-1]) {
            System.out.println("DEAD");
            return;
        }

        // BFS로 경로 탐색
        if (bfs()) {
            System.out.println("ALIVE");
        } else {
            System.out.println("DEAD");
        }
    }

    static boolean bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        int targetColor = board[0][0];

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            // 도착점에 도달했는지 확인
            if (cx == N-1 && cy == M-1) {
                return true;
            }

            // 맨해튼 거리가 X 이하인 모든 칸 탐색
            for (int nx = 0; nx < N; nx++) {
                for (int ny = 0; ny < M; ny++) {
                    // 맨해튼 거리 계산
                    int distance = Math.abs(nx - cx) + Math.abs(ny - cy);

                    // 조건 확인:
                    // 1. 맨해튼 거리가 X 이하
                    // 2. 아직 방문하지 않은 칸
                    // 3. 같은 색의 보도블록
                    // 4. 자기 자신이 아님 (distance > 0)
                    if (distance > 0 && distance <= X &&
                            !visited[nx][ny] &&
                            board[nx][ny] == targetColor) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        return false;
    }
}