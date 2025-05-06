package solved.silver.S2;
import java.io.*;
import java.util.*;

public class S2_24481 {
    static int N, M, R;
    static List<Integer>[] adj;
    static int[] depth;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        // 인접 리스트 초기화
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        // 간선 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }
        // 오름차순 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(adj[i]);
        }

        depth = new int[N + 1];
        Arrays.fill(depth, -1);      // 방문되지 않은 정점은 -1
        visited = new boolean[N + 1];

        // DFS (스택 사용)
        Deque<Frame> stack = new ArrayDeque<>();
        visited[R] = true;
        depth[R] = 0;
        stack.push(new Frame(R, 0));

        while (!stack.isEmpty()) {
            Frame cur = stack.peek();
            int u = cur.node;
            if (cur.nextIdx < adj[u].size()) {
                int v = adj[u].get(cur.nextIdx++);
                if (!visited[v]) {
                    visited[v] = true;
                    depth[v] = depth[u] + 1;
                    stack.push(new Frame(v, 0));
                }
            } else {
                stack.pop();
            }
        }

        // 결과 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= N; i++) {
            bw.write(depth[i] + "\n");
        }
        bw.flush();
    }

    // 스택 프레임: 현재 정점과 다음에 방문할 인접리스트 인덱스
    static class Frame {
        int node, nextIdx;
        Frame(int node, int nextIdx) {
            this.node = node;
            this.nextIdx = nextIdx;
        }
    }
}
