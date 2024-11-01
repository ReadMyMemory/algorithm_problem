package solved_ac_step.class4;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


// 프로그래머스식으로 풀었음.

public class G3_2206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N+1][M+1]; // 이게 실제로는 M+1이 가로를, N+1이 세로를 나타는 거라서, x y를 바꿔서 생각해야 한다.
        for(int i = 1; i <= N; i++) {
            String s = br.readLine();
            for(int j = 1; j <= M; j++)
                map[i][j] = s.charAt(j-1) - '0';
        }

        //입력 확인 용
//        for(int i = 1; i <= N; i++) {
//            for(int j = 1; j <= M; j++) {
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.println();
//        }
        System.out.println(solution(N, M, map));
    }
    static class Pair {
        int x, y, breakingWall;
        public Pair(int y, int x, int breakingWall) {
            this.y = y;
            this.x = x;
            this.breakingWall = breakingWall;
        }
    }

    private static int solution(int N, int M, int[][] map) {
        //bfs를 위한 준비물 5가지(지도, 방문처리, dx, dy, queue)
        int[][][] visited = new int[N + 1][M + 1][2];
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        Queue<Pair> q = new LinkedList<>();

        visited[1][1][0] = 1;
        q.add(new Pair(1, 1, 0));

        while(!q.isEmpty()) {
            Pair cur = q.poll();

            //조건 1. 도착점에 도착했는가?
            if(cur.x == M && cur.y == N) //y에 N, x에 M이 맞물린다.
                return visited[cur.y][cur.x][cur.breakingWall];

            for(int i = 0; i < 4; i++) {
                Pair next = new Pair(cur.y + dy[i],cur.x + dx[i], cur.breakingWall);

                //조건 2. 벽에 부딪히는가?
                if(next.y <= 0 || next.y > N || next.x <= 0 || next.x > M)
                    continue;
                //조건 3. 방문했는가?
                if(visited[next.y][next.x][cur.breakingWall] != 0)
                    continue;

                if(map[next.y][next.x] == 0) { // 벽을 뚫지 않고 갈 수 있음
                    visited[next.y][next.x][next.breakingWall] = visited[cur.y][cur.x][cur.breakingWall] + 1;
                    q.add(next);
                }

                if(map[next.y][next.x] == 1 && next.breakingWall == 0) {// 벽을 뚫어야 하고, 아직 안뚫었을때
                    visited[next.y][next.x][1] = visited[cur.y][cur.x][cur.breakingWall] + 1;
                    next.breakingWall = 1;
                    q.add(next);
                }
            }
        }
        //조건 4. 도착점에 도달하지 못했다면
        return -1;
    }
}
