package solved.silver.S2;
import java.io.*;
import java.util.*;

public class S2_1326 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int[] a = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) a[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N, a, S, E));
    }

    private static int bfs(int N, int[] a, int S, int E) {
        if (S == E) return 0;

        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);

        ArrayDeque<Integer> q = new ArrayDeque<>();
        dist[S] = 0;
        q.offer(S);

        while (!q.isEmpty()) {
            int cur = q.poll();
            int step = a[cur];

            // 오른쪽으로 점프: cur + k*step
            for (int next = cur + step; next <= N; next += step) {
                if (dist[next] != -1) continue;
                dist[next] = dist[cur] + 1;
                if (next == E) return dist[next];
                q.offer(next);
            }

            // 왼쪽으로 점프: cur - k*step
            for (int next = cur - step; next >= 1; next -= step) {
                if (dist[next] != -1) continue;
                dist[next] = dist[cur] + 1;
                if (next == E) return dist[next];
                q.offer(next);
            }
        }
        return -1; // 도달 불가
    }
}
