package solved_ac_step.class4;
import java.io.*;
import java.util.*;

public class G4_1753 {
    private static class Node implements Comparable<Node> {
        int e;
        long cost;
        public Node(int e, long cost) {
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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        for(int i = 0; i <= V; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // 시작점 u
            int v = Integer.parseInt(st.nextToken()); // 도착점 v
            long w = Long.parseLong(st.nextToken()); // 가중치 w
            list.get(u).add(new Node(v, w));
        }

        Long INF = 60000000001L; // 20000 * 300000 * 10 + 1 이다.
        Long[] dist = new Long[V + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0L;
        //우선 순위 큐를 사용하여 가장 비용이 적은 노드를 먼저 선택하여 거리를 갱신할 수 있다. 
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start, 0));
        while(!queue.isEmpty()) {
            Node curNode = queue.poll();
            int cur = curNode.e;

            for(Node node : list.get(cur))
                if(dist[node.e] > dist[cur] + node.cost) {
                    dist[node.e] = dist[cur] + node.cost;
                    queue.add(new Node(node.e, dist[node.e]));
                }
        }

        for(int i = 1; i <= V; i++) {
            if(Objects.equals(dist[i], INF))
                bw.write("INF\n");
            else
                bw.write(dist[i]+"\n");
        }
        bw.flush();
        br.close();
        bw.close();

    }
}
