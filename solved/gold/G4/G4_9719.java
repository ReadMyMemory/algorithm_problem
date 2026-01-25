package solved.gold.G4;
import java.io.*;
import java.util.*;

/*
 * 아이디어:
 * - 인접한 정점이 같은 색을 가질 수 없으므로 그래프는 이분 그래프여야 한다.
 * - BFS/DFS로 각 연결 요소를 2색(0/1)으로 칠하며 충돌이 있으면 불가능(-1).
 * - 하나의 연결 요소는 전체 색을 뒤집는 경우까지 포함해 항상 2가지 방법이 존재한다.
 * - 연결 요소가 k개라면 전체 경우의 수는 2^k 이다.
 * - 간선이 없는 고립 정점도 하나의 연결 요소로 계산한다.
 */

public class G4_9719 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    // 이런 식으로 헬퍼유틸두면 하면 매번 readLine 할필요없어서 간편한듯??
    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) return null;
            if (line.trim().isEmpty()) continue;
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public static void main(String[] args) throws Exception {

        int T = nextInt();
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < T; tc++) {
            int V = nextInt();
            int E = nextInt();

            List<Integer>[] g = new ArrayList[V];
            for (int i = 0; i < V; i++) g[i] = new ArrayList<>();

            for (int i = 0; i < E; i++) {
                int a = nextInt();
                int b = nextInt();
                g[a].add(b);
                g[b].add(a);
            }

            int[] color = new int[V];
            Arrays.fill(color, -1);

            int components = 0;
            boolean ok = true;
            ArrayDeque<Integer> q = new ArrayDeque<>();

            for (int i = 0; i < V && ok; i++) {
                if (color[i] != -1) continue;

                components++;
                color[i] = 0;
                q.add(i);

                while (!q.isEmpty() && ok) {
                    int cur = q.poll();
                    for (int nxt : g[cur]) {
                        if (color[nxt] == -1) {
                            color[nxt] = 1 - color[cur];
                            q.add(nxt);
                        } else if (color[nxt] == color[cur]) {
                            ok = false;
                        }
                    }
                }
            }

            if (!ok) {
                sb.append("-1\n");
            } else {
                sb.append(1L << components).append('\n');
            }
        }
        System.out.print(sb);
    }
}
