package solved.gold.G5;
import java.io.*;
import java.util.*;

public class G5_1240 {
    static class Edge {
        int to;
        int cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static class Node {
        int num;
        int dist;

        Node(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }
    }

    static List<Edge>[] graph;
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, dist));
            graph[b].add(new Edge(a, dist));
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(bfs(start, end)).append('\n');
        }
        System.out.print(sb);
    }

    static int bfs(int start, int end) {
        boolean[] visited = new boolean[n + 1];
        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(start, 0));
        visited[start] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.num == end) {
                return cur.dist;
            }

            for (Edge next : graph[cur.num]) {
                if (!visited[next.to]) {
                    visited[next.to] = true;
                    queue.offer(new Node(next.to, cur.dist + next.cost));
                }
            }
        }
        return 0;
    }
}