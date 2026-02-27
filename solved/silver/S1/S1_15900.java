package solved.silver.S1;
import java.io.*;
import java.util.*;

public class S1_15900 {
    static class FastInput {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
        int nextInt() throws IOException { return Integer.parseInt(next()); }
    }

    static int[] head, to, next;
    static int edgeIdx = 0;

    static void addEdge(int u, int v) {
        to[edgeIdx] = v;
        next[edgeIdx] = head[u];
        head[u] = edgeIdx++;
    }

    public static void main(String[] args) throws Exception {
        FastInput in = new FastInput();
        int n = in.nextInt();

        head = new int[n + 1];
        Arrays.fill(head, -1);
        to = new int[2 * (n - 1)];
        next = new int[2 * (n - 1)];

        for (int i = 0; i < n - 1; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            addEdge(a, b);
            addEdge(b, a);
        }

        int[] parent = new int[n + 1];
        int[] depth = new int[n + 1];

        int[] stack = new int[n];
        int top = 0;

        parent[1] = 0;
        depth[1] = 0;
        stack[top++] = 1;

        long sumLeafDepth = 0;

        while (top > 0) {
            int v = stack[--top];

            boolean isLeaf = true; // 루트 기준으로 자식이 없으면 leaf
            for (int e = head[v]; e != -1; e = next[e]) {
                int w = to[e];
                if (w == parent[v]) continue;
                isLeaf = false;
                parent[w] = v;
                depth[w] = depth[v] + 1;
                stack[top++] = w;
            }

            if (v != 1 && isLeaf) {
                sumLeafDepth += depth[v];
            }
        }
        System.out.println((sumLeafDepth % 2 == 1) ? "Yes" : "No");
    }
}