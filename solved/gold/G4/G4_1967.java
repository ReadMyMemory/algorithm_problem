package solved.gold.G4;
import java.io.*;
import java.util.*;

public class G4_1967 {
    static ArrayList<Node>[] tree;
    static boolean[] visited;
    static int farthestNode;
    static int maxDistance;

    static class Node {
        int to;
        int weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            tree[parent].add(new Node(child, weight));
            tree[child].add(new Node(parent, weight));
        }

        // 노드가 1개인 경우
        if (n == 1) {
            System.out.println(0);
            return;
        }

        // 첫 번째 DFS: 임의의 노드(1번)에서 가장 먼 노드 찾기
        visited = new boolean[n + 1];
        maxDistance = 0;
        farthestNode = 1;  // 초기화
        dfs(1, 0);

        // 두 번째 DFS: 찾은 노드에서 가장 먼 노드까지의 거리가 지름
        visited = new boolean[n + 1];
        maxDistance = 0;
        dfs(farthestNode, 0);

        System.out.println(maxDistance);
    }

    static void dfs(int node, int distance) {
        visited[node] = true;

        if (distance > maxDistance) {
            maxDistance = distance;
            farthestNode = node;
        }

        for (Node next : tree[node]) {
            if (!visited[next.to]) {
                dfs(next.to, distance + next.weight);
            }
        }
    }
}