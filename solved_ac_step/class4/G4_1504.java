package solved_ac_step.class4;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/* 다익스트라(Djikstra) 알고리즘 적용
다만 무조건 거쳐가야 하는 구간 존재한다. u - v
따라서
시작점 -> u -> v -> 도착점
시작점 -> v -> u -> 도착점
이 두가지에 다익스트라를 적용하여 최단거리를 구하고, 구할 수 없으면 -1를 출력하면 되겠다.
*/

public class G4_1504 {

    //PriorityQueue를 사용하며 Node cannot be cast to class java.lang.Comparable 에러가 떠서 아래 내용을 까먹은 것을 확인하여 추가.
    private static class Node implements Comparable<Node>{
        int e, cost;
        public Node(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node node) {
            return cost - node.cost;
        }
    }





    static ArrayList<ArrayList<Node>> list;
    static int N, E;
    static int[] dist;
    static boolean[] visited;
    static int INF = 20000001;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //N, E 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        dist = new int[N + 1];
        Arrays.fill(dist, INF);


        //그래프 정보 기록
        list = new ArrayList<>();
        for(int i = 0; i <= N; i++)
            list.add(new ArrayList<>());

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            // 방향성이 없으므로 둘 다 추가
            list.get(a).add(new Node(b, c));
            list.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        // start -> u -> v -> end
        int distance = 0;
        distance += dijkstra(1, u);
        distance += dijkstra(u, v);
        distance += dijkstra(v, N);

        //start -> v -> u -> end
        int distance2 = 0;
        distance2 += dijkstra(1, v);
        distance2 += dijkstra(v, u);
        distance2 += dijkstra(u, N);

        if(distance >= INF && distance2 >= INF)
            System.out.println(-1);
        else
            System.out.println(Math.min(distance, distance2));

    }
    private static int dijkstra(int start, int end) {
        //다익스트라 실행할때마다 매번 초기화
        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            int cur = curNode.e;

            if (!visited[cur]) {
                visited[cur] = true;

                for (Node node : list.get(cur)) {
                    if (!visited[node.e] && dist[node.e] > dist[cur] + node.cost) {
                        dist[node.e] = dist[cur] + node.cost;
                        queue.add(new Node(node.e, dist[node.e]));
                    }
                }
            }
        }
        return dist[end];
    }
}
