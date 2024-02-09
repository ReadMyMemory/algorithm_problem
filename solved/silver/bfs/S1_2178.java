package solved.silver.bfs;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class S1_2178 {

    static class Pair {
        int y, x;
        public Pair(int x, int y) {
            this.y = y;
            this.x = x;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        // bfs를 위한 4가지 준비물
        int[][] map = new int[N][M]; //1. 실제 지도
        boolean[][] visited = new boolean[N][M]; // 2. 방문처리지도
        int[] dy = {-1, 1, 0, 0}; // 3. bfs 탐색을 위한 상하좌우 탐색
        int[] dx = {0, 0, -1, 1};
        Queue<Pair> q = new LinkedList<Pair>(); // 4. bfs를 위한 큐


        // 지도 입력
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        visited[0][0] = true;
        q.add(new Pair(0, 0)); // 시작지점

        while(!q.isEmpty()) {
            Pair pi = q.poll();
            int y = pi.y;
            int x = pi.x;

            for(int p = 0; p < 4; p++) {
                int ny = y + dy[p];
                int nx = x + dx[p];

                // 맵을 벗어난 경우, 탐색할 가치가 업는 경우, 이미 방문한 경우
                if (nx >= N || nx < 0 || ny >= M || ny < 0) continue;
                if (map[nx][ny] == 0) continue;
                if (visited[nx][ny]) continue;

                q.add(new Pair(nx, ny));
                map[nx][ny] = map[x][y] + 1;
                visited[nx][ny] = true;
            }
        }

        bw.write(map[N-1][M-1]+"");
        bw.flush();
    }
}
