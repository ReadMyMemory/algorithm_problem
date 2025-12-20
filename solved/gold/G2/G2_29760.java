package solved.gold.G2;
import java.io.*;
import java.util.*;

public class G2_29760 {
    static final long INF = (long) 4e18;

    // 한 층의 목표 방들이 만드는 [L, R] 구간을 모두 방문하면서
    // 시작 호 a, 종료 호 b로 끝낼 때의 최소 가로 이동 비용
    static long coverCost(boolean hasTarget, int L, int R, int a, int b) {
        if (!hasTarget) {
            return Math.abs(a - b);
        }
        long len = R - L;
        long option1 = Math.abs(a - L) + Math.abs(b - R);
        long option2 = Math.abs(a - R) + Math.abs(b - L);
        return len + Math.min(option1, option2);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        boolean[] has = new boolean[H + 1];
        int[] L = new int[H + 1];
        int[] R = new int[H + 1];
        Arrays.fill(L, Integer.MAX_VALUE);
        Arrays.fill(R, Integer.MIN_VALUE);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            has[x] = true;
            L[x] = Math.min(L[x], y);
            R[x] = Math.max(R[x], y);
        }

        // 방문해야 하는 층 목록(목표가 있는 층들) + 시작층 1층
        ArrayList<Integer> floors = new ArrayList<>();
        floors.add(1);
        for (int f = 2; f <= H; f++) {
            if (has[f]) floors.add(f);
        }

        Collections.sort(floors);

        // 첫 처리 층은 1층
        long[] dp = new long[W + 1];
        Arrays.fill(dp, INF);

        // 시작 위치: (1층, 1호)
        int startCol = 1;
        int f0 = 1;

        // 1층에서 바로 끝 호 b로 만들면서 목표(있으면) 커버하깅
        for (int b = 1; b <= W; b++) {
            dp[b] = coverCost(has[f0], L[f0], R[f0], startCol, b);
        }

        // 다음 목표층들 처리
        for (int idx = 1; idx < floors.size(); idx++) {
            int f = floors.get(idx);
            int prevF = floors.get(idx - 1);
            long vertical = 100L * (f - prevF);

            long[] ndp = new long[W + 1];
            Arrays.fill(ndp, INF);

            for (int a = 1; a <= W; a++) {
                long base = dp[a];
                if (base >= INF) continue;

                for (int b = 1; b <= W; b++) {
                    long cost = base + vertical + coverCost(has[f], L[f], R[f], a, b);
                    if (cost < ndp[b]) ndp[b] = cost;
                }
            }
            dp = ndp;
        }

        long ans = INF;
        for (int c = 1; c <= W; c++) ans = Math.min(ans, dp[c]);
        System.out.println(ans);
    }
}
