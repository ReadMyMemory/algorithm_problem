package solved_ac_step.class3;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_1012 {
    static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] map;
    static boolean[][] visited;
    /* 기본적으로 이차원 배열은
    M = 4 N =3 int[N][M]이라면
    x x x x
    x x x x
    x x x x
    [][] 에서 앞에 쓰인게 세로 크기, 뒤에 쓰인게 가로 크기 입니다.
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int testcase = Integer.parseInt(br.readLine());
        while(testcase > 0) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // X
            int N = Integer.parseInt(st.nextToken()); // Y
            int K = Integer.parseInt(st.nextToken()); // 배추 개수
            //bfs를 위한 4가지 준비물
            map = new int[M][N]; //1. 실제 지도, [M][N] 으로 받는다는 것은 90도 돌려서 보겠다는 뜻입니다.
            visited = new boolean[M][N]; //2. 방문처리지도, M은 이제 세로길이가 됩니다. N은 가로길이가 되고요.
            int[] dy = {-1, 1, 0, 0}; //3. 상하좌우 탐색을 위한 dy, dx
            int[] dx = {0, 0, -1, 1};
            Queue<Pair> q = new LinkedList<Pair>(); //4. bfs를 위한 큐

            //지도에 배추 위치 입력
            while(K > 0) {
                st = new StringTokenizer(br.readLine());
                map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
                K--;
            }

            //bfs 수행. 구역 구하기
            int count = 0;

            for(int i = 0; i < M; i++) {
                for(int j = 0; j < N; j++) {
                    if(!visited[i][j] && map[i][j] == 1) {
                        visited[i][j] = true;
                        count++;
                        q.add(new Pair(i, j));

                        while(!q.isEmpty()) {
                            Pair pi = q.poll();
                            int x = pi.x;
                            int y = pi.y;

                            for(int p = 0; p < 4; p++) {
                                int ny = y + dy[p];
                                int nx = x + dx[p];

                                // 맵을 벗어난 경우, 탐색할 가치가 업는 경우, 이미 방문한 경우
                                if(nx >= M || nx < 0 || ny >= N || ny < 0) continue;
                                if(map[nx][ny] == 0) continue;
                                if(visited[nx][ny]) continue;

                                visited[nx][ny] = true;
                                q.add(new Pair(nx, ny));
                            }
                        }
                    }
                }
            }
            bw.write(count+"\n");
            testcase--;
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
