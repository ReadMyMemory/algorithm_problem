package solved.gold.G4;
import java.io.*;
import java.util.*;

public class G4_3190 {
    static class Turn {
        int t; char c;
        Turn(int t, char c){ this.t=t; this.c=c; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int K = Integer.parseInt(br.readLine().trim());
        boolean[][] apple = new boolean[N + 1][N + 1];
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            apple[r][c] = true;
        }

        int L = Integer.parseInt(br.readLine().trim());
        Queue<Turn> turns = new ArrayDeque<>();
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            turns.add(new Turn(t, c));
        }

        // 오른쪽, 아래, 왼쪽, 위
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        Deque<int[]> snake = new ArrayDeque<>();
        boolean[][] occupy = new boolean[N + 1][N + 1];

        int dir = 0;          // 시작 방향: 오른쪽
        int x = 1, y = 1;     // 시작 위치
        snake.addFirst(new int[]{x, y});
        occupy[x][y] = true;

        int time = 0;

        while (true) {
            time++;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 벽 충돌
            if (nx < 1 || nx > N || ny < 1 || ny > N) {
                System.out.println(time);
                return;
            }
            // 몸 충돌
            if (occupy[nx][ny]) {
                System.out.println(time);
                return;
            }

            // 머리 이동
            snake.addFirst(new int[]{nx, ny});
            occupy[nx][ny] = true;

            // 사과 없으면 꼬리 제거
            if (apple[nx][ny]) {
                apple[nx][ny] = false;
            } else {
                int[] tail = snake.removeLast();
                occupy[tail[0]][tail[1]] = false;
            }

            x = nx; y = ny;

            // 방향 전환 시점 확인
            if (!turns.isEmpty() && turns.peek().t == time) {
                Turn turn = turns.poll();
                if (turn.c == 'L') dir = (dir + 3) % 4; // 왼쪽 회전
                else dir = (dir + 1) % 4;               // 오른쪽 회전
            }
        }
    }
}
