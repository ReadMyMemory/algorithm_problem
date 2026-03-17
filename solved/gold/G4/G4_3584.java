package solved.gold.G4;
import java.io.*;
import java.util.*;

public class G4_3584 {

    static List<Integer>[] children;
    static int[] parent;
    static int[] depth;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            children = new ArrayList[N + 1];
            parent = new int[N + 1];
            depth = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                children[i] = new ArrayList<>();
            }

            for (int i = 0; i < N - 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                parent[B] = A;
                children[A].add(B);
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int root = 1;
            for (int i = 1; i <= N; i++) {
                if (parent[i] == 0) {
                    root = i;
                    break;
                }
            }

            setDepth(root);

            int answer = lca(x, y);
            sb.append(answer).append('\n');
        }
        System.out.print(sb);
    }

    static void setDepth(int root) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        depth[root] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : children[cur]) {
                depth[next] = depth[cur] + 1;
                queue.offer(next);
            }
        }
    }

    static int lca(int a, int b) {
        while (depth[a] > depth[b]) {
            a = parent[a];
        }

        while (depth[b] > depth[a]) {
            b = parent[b];
        }

        while (a != b) {
            a = parent[a];
            b = parent[b];
        }
        return a;
    }
}