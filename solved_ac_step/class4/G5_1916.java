package solved_ac_step.class4;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
다익스트라의 전형적인 문제다.
우선순위큐와 인접 리스트를 사용했다.
프로그래머스식으로 풀어보았다.
*/


public class G5_1916 {
    static class Node implements Comparable<Node>{
        int e;
        long cost;
        Node(int e, long cost) {
            this.e = e;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node node) {
            return Long.compare(this.cost, node.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        for(int i = 0; i <= N; i++) //편의성을 위해 N까지 만들었다.
            list.add(new ArrayList<>());
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b, cost));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        System.out.println(solution(N, M, list, start, end));
    }

    static long solution(int city, int bus, ArrayList<ArrayList<Node>> map, int start, int end) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        Long INF = 10000000000L; // 버스 100000 * 비용 100000
        Long[] dist = new Long[city+1];
        boolean[] visited = new boolean[city+1];
        Arrays.fill(dist, INF);
        q.offer(new Node(start, 0));
        dist[start] = 0L;

        while(!q.isEmpty()) {
            Node curNode = q.poll();
            int cur = curNode.e;

            if(!visited[cur]) {
                visited[cur] = true;

                for(Node node : map.get(cur)) { // curNode의 e에서 연결된 노드를 다 탐색하여 거리를 갱신한다.
                    if(!visited[node.e] && dist[node.e] > dist[cur] + node.cost) {
                        dist[node.e] = dist[cur] + node.cost;
                        q.add(new Node(node.e, dist[node.e])); // 그리고 해당 지점에서 새로운 거리가 갱신되면 그 노드로 이동해 연결된 노드를 전부 탐색한다.
                    }
                }
            }
        }
        return dist[end];
    }
}
