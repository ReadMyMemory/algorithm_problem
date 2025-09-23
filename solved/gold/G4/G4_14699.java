package solved.gold.G4;
import java.io.*;
import java.util.*;

public class G4_14699 {
    static int N, M;
    static int[] height;
    static ArrayList<Integer>[] adj;
    static int[] dp;
    static boolean[] visited;

    // DP + DFS
    static int dfs(int cur) {
        if (dp[cur] != 0) return dp[cur];
        int max = 1; // 자기 자신 방문 포함
        for (int next : adj[cur]) {
            if (height[next] > height[cur]) { // 더 높은 곳으로만
                max = Math.max(max, dfs(next) + 1);
            }
        }
        return dp[cur] = max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        height = new int[N+1]; // 1-indexed
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        adj = new ArrayList[N+1];
        for (int i=1; i<=N; i++) adj[i] = new ArrayList<>();

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a); // 양방향 입력, 실제로는 높이로 단방향 처리
        }

        dp = new int[N+1];
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=N; i++) {
            sb.append(dfs(i)).append('\n');
        }
        System.out.print(sb);
    }
}
