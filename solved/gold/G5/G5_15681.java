package solved.gold.G5;
import java.io.*;
import java.util.*;

public class G5_15681 {
    static ArrayList<Integer>[] graph;
    static int[] parent;
    static int[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        parent = new int[N + 1];
        size = new int[N + 1];
        int[] order = new int[N];
        int idx = 0;

        // DFS
        Deque<Integer> stack = new ArrayDeque<>();
        parent[R] = 0;
        stack.push(R);

        while (!stack.isEmpty()) {
            int u = stack.pop();
            order[idx++] = u;
            for (int v : graph[u]) {
                if (v == parent[u]) continue;
                parent[v] = u;
                stack.push(v);
            }
        }

        // 서브트리 크기 계산 (역순)
        Arrays.fill(size, 1);
        for (int i = idx - 1; i >= 0; i--) {
            int u = order[i];
            for (int v : graph[u]) {
                if (parent[v] == u) size[u] += size[v];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int u = Integer.parseInt(br.readLine());
            sb.append(size[u]).append('\n');
        }

        System.out.print(sb);
    }
}
