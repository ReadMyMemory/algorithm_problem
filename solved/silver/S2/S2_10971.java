package solved.silver.S2;
import java.io.*;
import java.util.*;

public class S2_10971 {
    static int N;
    static int[][] W;
    static int[][] dp;
    static final int INF = 1_000_000 * 10 + 1; // 문제 조건상 충분히 큰 값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        dp = new int[N][1 << N];

        // 비용 행렬 입력 받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // -1로 초기화 (아직 방문하지 않은 상태)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < (1 << N); j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(tsp(0, 1)); // 0번 도시에서 시작, 1(0번 도시만 방문) 상태
    }

    // 현재 위치가 current, 방문한 도시 bitmask가 visited
    static int tsp(int current, int visited) {
        if (visited == (1 << N) - 1) { // 모두 방문했다면
            if (W[current][0] == 0) return INF; // 다시 출발점으로 못 가는 경우
            return W[current][0]; // 출발점으로 돌아가는 비용
        }

        if (dp[current][visited] != -1) {
            return dp[current][visited];
        }

        int minCost = INF;
        for (int next = 0; next < N; next++) {
            // 방문하지 않았고, 길이 존재한다면
            if ((visited & (1 << next)) == 0 && W[current][next] != 0) {
                int cost = tsp(next, visited | (1 << next)) + W[current][next];
                minCost = Math.min(minCost, cost);
            }
        }

        dp[current][visited] = minCost;
        return minCost;
    }
}
