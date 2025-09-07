package solved.gold;
import java.io.*;
import java.util.*;

public class G3_15938 {
    static final int MOD = 1000000007;
    static final int OFFSET = 200;
    static final int SIZE = 401;

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 성원이의 현재 위치
        StringTokenizer st = new StringTokenizer(br.readLine());
        int xs = Integer.parseInt(st.nextToken());
        int ys = Integer.parseInt(st.nextToken());

        // 버틸 수 있는 시간
        int T = Integer.parseInt(br.readLine());

        // 집의 위치
        st = new StringTokenizer(br.readLine());
        int xh = Integer.parseInt(st.nextToken());
        int yh = Integer.parseInt(st.nextToken());

        // 집의 상대 좌표 계산
        int hx = xh - xs + OFFSET;
        int hy = yh - ys + OFFSET;

        // 집이 이동 가능 범위를 벗어난 경우
        if (hx < 0 || hx >= SIZE || hy < 0 || hy >= SIZE) {
            System.out.println(0);
            return;
        }

        // 장애물 입력
        int N = Integer.parseInt(br.readLine());
        boolean[][] obstacle = new boolean[SIZE][SIZE];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int ox = x - xs + OFFSET;
            int oy = y - ys + OFFSET;

            if (ox >= 0 && ox < SIZE && oy >= 0 && oy < SIZE) {
                obstacle[ox][oy] = true;
            }
        }

        // 시작점이나 집이 장애물인 경우
        if (obstacle[OFFSET][OFFSET] || obstacle[hx][hy]) {
            System.out.println(0);
            return;
        }

        // DP 배열
        long[][][] dp = new long[T + 1][SIZE][SIZE];

        // 각 시간에 방문 가능한 위치들을 저장
        List<Point>[] candidates = new ArrayList[T + 1];
        for (int i = 0; i <= T; i++) {
            candidates[i] = new ArrayList<>();
        }

        // 방문 체크 배열 (중복 추가 방지)
        boolean[][][] visited = new boolean[T + 1][SIZE][SIZE];

        // 초기 설정
        dp[0][OFFSET][OFFSET] = 1;
        candidates[0].add(new Point(OFFSET, OFFSET));
        visited[0][OFFSET][OFFSET] = true;

        // 집 위치는 모든 시간에 visited 처리 (집에 도착하면 멈추므로)
        for (int t = 0; t <= T; t++) {
            visited[t][hx][hy] = true;
        }

        // 방향 벡터
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // BFS 진행
        for (int t = 0; t < T; t++) {
            for (Point p : candidates[t]) {
                int x = p.x;
                int y = p.y;

                if (dp[t][x][y] == 0) continue;

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    // 범위 체크
                    if (nx < 0 || nx >= SIZE || ny < 0 || ny >= SIZE) continue;

                    // 장애물 체크
                    if (obstacle[nx][ny]) continue;

                    // DP 업데이트
                    dp[t + 1][nx][ny] = (dp[t + 1][nx][ny] + dp[t][x][y]) % MOD;

                    // 아직 큐에 추가되지 않은 위치라면 추가
                    if (!visited[t + 1][nx][ny]) {
                        visited[t + 1][nx][ny] = true;
                        candidates[t + 1].add(new Point(nx, ny));
                    }
                }
            }
        }

        // 답 계산: 0초부터 T초까지 집에 도착한 모든 경우의 수
        long answer = 0;
        for (int t = 0; t <= T; t++) {
            answer = (answer + dp[t][hx][hy]) % MOD;
        }
        System.out.println(answer);
    }
}