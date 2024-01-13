package Arena.season17;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//다익스트라와 역추적에 대해 공부하고 다시 풀어봐야겠다.
// 어려워..



public class D4 {
    static int INF = 100000000;
    static int N, M, A, B;
    static int[][] map;
    static boolean[] visited;
    static int[] d;
    static ArrayList<Integer> link; // 경로 처리
    static int minIndex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 도시의 개수
        M = Integer.parseInt(st.nextToken()); // 도로의 개수
        A = Integer.parseInt(st.nextToken()); //민겸이가 살고 있는 도시 번호
        B = Integer.parseInt(st.nextToken()); //시은이가 살고 있는 도시 번호

        map = new int[N+1][N+1]; // 보기 편하게 하려고 index+1로 잡음.
        visited = new boolean[N+1]; // 노드 방문 처리 여부
        d = new int[N+1]; // 최단 거리

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                map[i][j] = INF;
            }
        }

        //지도 입력 받기
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            map[start][end] = map[end][start] = weight;
        }

        link = new ArrayList<>();
        //다익스트라로 구하면 될 것 같다.
        link.add(A); // 시작점 경로 추가
        dijkstra(A); // A를 기준으로 최단 거리 구하기.
//        for(int i = 1; i <= N; i++) {
//            for(int j = 1; j <= N; j++) {
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.println();
//        }
//        for(int a : d)
//            System.out.print(a+" ");
        System.out.println(link.size());
        for(int a : link)
            bw.write(a+" ");
        bw.flush();
        br.close();
        bw.close();
    }
    static int getSmallIndex() {
        int min = INF;
        int index = 0;
        for(int i = 1; i <= N; i++) {
            if(d[i] < min && !visited[i]) {
                min = d[i];
                index = i;
            }
        }
        return index;
    }

    static void dijkstra(int start) {
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <=N; i++) {
            d[i] = map[start][i];
            if(d[i] != 0 && min > d[i]) {
                min = d[i];
                minIndex = i;
            }
        }
        link.add(start);
        link.add(minIndex);
        visited[start] = true;
        for(int i = 1; i <= N - 2; i++) { // 방문한 노드는 최단경로임이 확정되어 마지막 남은 노드에서 최단경로를 갱신해주는 경우가 발생하지 않아 굳이 방문 안해도 된다.
            int current = getSmallIndex();
            visited[current] = true;
            for(int j = 1; j <= N; j++) {
                if(!visited[j]) {
                    if(d[current] + map[current][j] < d[j]) {
                        d[j] = d[current] + map[current][j];
                        if(min > d[j])
                            removeValue(j);
                        link.add(current);
                        link.add(j);
                    }
                }
            }
        }
    }

    static void removeValue(int value) {
        for(int i = 0; i < link.size(); i++) {
            if(link.get(i).equals(value)) {
                link.remove(i);
                break;
            }
        }
    }
}
