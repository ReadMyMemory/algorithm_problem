package solved.gold.G3;
import java.io.*;
import java.util.*;

public class G3_1005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 건물 개수
            int K = Integer.parseInt(st.nextToken()); // 규칙 개수

            int[] time = new int[N + 1]; // 각 건물 건설 시간
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                time[i] = Integer.parseInt(st.nextToken());
            }

            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            int[] indegree = new int[N + 1]; // 진입 차수

            // 건설 순서 입력
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                graph.get(X).add(Y);
                indegree[Y]++;
            }

            int W = Integer.parseInt(br.readLine()); // 목표 건물

            // 위상정렬 + DP
            int[] dp = new int[N + 1]; // dp[i] = i번 건물까지 짓는데 걸리는 최소 시간
            Queue<Integer> queue = new LinkedList<>();

            // 진입차수가 0인 건물부터 시작
            for (int i = 1; i <= N; i++) {
                if (indegree[i] == 0) {
                    queue.offer(i);
                    dp[i] = time[i];
                }
            }

            while (!queue.isEmpty()) {
                int current = queue.poll();

                // 현재 건물을 지은 후 지을 수 있는 건물들 확인
                for (int next : graph.get(current)) {
                    // 다음 건물을 짓기 위한 시간 갱신
                    // 선행 건물들 중 가장 오래 걸리는 시간 + 현재 건물 시간
                    dp[next] = Math.max(dp[next], dp[current] + time[next]);

                    indegree[next]--;
                    if (indegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
            sb.append(dp[W]).append("\n");
        }
        System.out.print(sb);
    }
}