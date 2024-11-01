package solved_ac_step.class4;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


// 프로그래머스식으로 풀었음.
/*
https://www.acmicpc.net/board/view/27386
참고했다

벽을 뚫은 세계선을 1, 안 뚫은 세계를 0으로 한다면
탐색을 하면서 벽을 뚫어야 할때는 내가 아직 뚫었는지의 상태를 체크하고 뚫는 세계선을 만든다.
그리고 그 상태는 계속해서 탐색하는 동안 유지되야 한다.
0 -> 1 일때 아래 코드를 통해 벽을 뚫었다는 상태를 전달한다.

visited[next.y][next.x][1] = visited[cur.y][cur.x][cur.breakingWall] + 1;
next.breakingWall = 1;
q.add(next)

breakingWall이라는 상태를 계속해서 유지함으로써, 만약에 탐색 중에 벽을 뚫었다면,
cur.breakingWall에 1이라는 값이 계속해서 전달되며 유지될 것이다.
따라서 맵의 한 지점에서 breakingWall이 0이였을 때 방문값과 1이였을 때 방문값이 동시에 존재할 수 있는 것이다.
아니 그러면, 도착점에 도달하는 경우도 여러가지가 있을 수 있는데,
그렇게 탐색하다가 먼저 리턴되는 값이 최단 경로임을 증명할 수 있는가? 라고 의문점이 들었다.
내가 이런 의문점을 생각하면서 간과했던 부분은 "한번 방문한 지점은 재방문하지 않는다." 였다. 즉 breakingWall = 1 or 0인 2가지로 귀결된다.
그러면 먼저 방문했을 때의 거리가 8이였다면, 새롭게 탐색했을 때 거리가 6인 경우가 존재하면 어떻게 하냐? 라는 의문점이 들었다.
이 의문점은 위에 백준 FAQ 링크를 통해 해결할 수 있었다.
 특정 칸에 처음 도달했을 때까지의 경로의 길이가 다른 경로를 통해 도달한 길이보다 짧다는 보장을 할 수 있느냐 없느냐의 문제였는데,
 bfs를 통해 탐색하는 경우 이를 보장하는 것이다.

만약에 벽을 뚫고 가지 않아도 도착점에 도달할 수 있었고,
벽을 뚫어도 도착점에 도달할 수 있는데 그 거리가 같다고 해보자.
예를 들면
4 4
0000
1101
0000
0000
같은 경우다.
이 경우는 벽을 뚫던 말던 7로 최단거리가 같다.

5 4
0000
1110
0000
0111
0000
이 경우는 벽을 뚫는 경로가 훨씬 가깝기 때문에 최단거리는 8이다.

 */

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
