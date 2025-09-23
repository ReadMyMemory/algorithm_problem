package solved.gold.G4;
import java.io.*;
import java.util.*;

public class G4_2056 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] time = new int[N + 1];    // 각 작업의 소요 시간
        int[] indegree = new int[N + 1]; // 진입차수 (선행 작업 개수)
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        int[] dp = new int[N + 1];      // 각 작업을 끝내는 최소 시간

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                int pre = Integer.parseInt(st.nextToken());
                graph[pre].add(i); // pre -> i
                indegree[i]++;
            }
        }

        // 위상정렬
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                dp[i] = time[i];
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph[now]) {
                dp[next] = Math.max(dp[next], dp[now] + time[next]);
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}
