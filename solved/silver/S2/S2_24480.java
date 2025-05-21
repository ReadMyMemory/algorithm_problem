package solved.silver.S2;
import java.io.*;
import java.util.*;

public class S2_24480 {
    static ArrayList<Integer>[] graph;
    static int[] visitOrder;
    static int order = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 정점 개수
        int M = Integer.parseInt(st.nextToken()); // 간선 개수
        int R = Integer.parseInt(st.nextToken()); // 시작 정점

        // 인접 리스트 초기화
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        // 각 인접 리스트 내림차순 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i], Collections.reverseOrder());
        }

        visitOrder = new int[N + 1];
        dfs(R);

        // 정답 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(visitOrder[i]).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int v) {
        visitOrder[v] = order++;
        for (int next : graph[v]) {
            if (visitOrder[next] == 0) {
                dfs(next);
            }
        }
    }
}
