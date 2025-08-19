package solved.silver.S1;
import java.io.*;
import java.util.*;

public class S1_3184 {
    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        // 맵 입력 받기
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int totalSheep = 0;
        int totalWolves = 0;

        // 각 영역 탐색
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j] && map[i][j] != '#') {
                    int[] result = bfs(i, j);
                    int sheepInArea = result[0];
                    int wolvesInArea = result[1];

                    // 영역 내 승자 결정
                    if (sheepInArea > wolvesInArea) {
                        totalSheep += sheepInArea;
                    } else {
                        totalWolves += wolvesInArea;
                    }
                }
            }
        }

        System.out.println(totalSheep + " " + totalWolves);
    }

    static int[] bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;

        int sheepCount = 0;
        int wolfCount = 0;

        // 시작 위치 확인
        if (map[startX][startY] == 'o') {
            sheepCount++;
        } else if (map[startX][startY] == 'v') {
            wolfCount++;
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 체크
                if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                    continue;
                }

                // 방문했거나 울타리인 경우 스킵
                if (visited[nx][ny] || map[nx][ny] == '#') {
                    continue;
                }

                visited[nx][ny] = true;

                // 양 또는 늑대 카운트
                if (map[nx][ny] == 'o') {
                    sheepCount++;
                } else if (map[nx][ny] == 'v') {
                    wolfCount++;
                }

                queue.offer(new int[]{nx, ny});
            }
        }

        return new int[]{sheepCount, wolfCount};
    }
}