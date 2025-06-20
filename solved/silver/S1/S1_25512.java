package solved.silver.S1;
import java.io.*;
import java.util.*;

public class S1_25512 {
    static int n;
    static List<Integer>[] tree;
    static int[][] cost;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();

        // 트리 입력
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            tree[p].add(c);
            tree[c].add(p);
        }

        // 색칠 비용 입력
        cost = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken()); // white
            cost[i][1] = Integer.parseInt(st.nextToken()); // black
        }

        dp = new long[n][2];
        for (long[] arr : dp) Arrays.fill(arr, -1);

        long answer = Math.min(dfs(0, -1, 0), dfs(0, -1, 1));
        System.out.println(answer);
    }

    // node: 현재 정점, parent: 부모 정점, color: 현재 정점의 색 (0: white, 1: black)
    static long dfs(int node, int parent, int color) {
        if (dp[node][color] != -1) return dp[node][color];
        long sum = cost[node][color];
        for (int next : tree[node]) {
            if (next == parent) continue;
            // 자식은 현재 색과 다르게 칠해야 함
            sum += dfs(next, node, 1 - color);
        }
        return dp[node][color] = sum;
    }
}
