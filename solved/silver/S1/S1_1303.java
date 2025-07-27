package solved.silver.S1;
import java.io.*;
import java.util.*;

public class S1_1303 {
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    // 상하좌우만 인접
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 가로
        M = Integer.parseInt(st.nextToken()); // 세로

        map = new char[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int whitePower = 0, bluePower = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    int cnt = bfs(i, j, map[i][j]);
                    if (map[i][j] == 'W') {
                        whitePower += cnt * cnt;
                    } else {
                        bluePower += cnt * cnt;
                    }
                }
            }
        }
        System.out.println(whitePower + " " + bluePower);
    }

    static int bfs(int y, int x, char color) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {y, x});
        visited[y][x] = true;
        int count = 1;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int curY = now[0];
            int curX = now[1];
            for (int d = 0; d < 4; d++) {
                int ny = curY + dy[d];
                int nx = curX + dx[d];
                if (ny >= 0 && ny < M && nx >= 0 && nx < N) {
                    if (!visited[ny][nx] && map[ny][nx] == color) {
                        visited[ny][nx] = true;
                        queue.add(new int[] {ny, nx});
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
