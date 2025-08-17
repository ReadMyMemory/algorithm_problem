package solved.gold;
import java.io.*;
import java.util.*;

public class G3_17471 {
    static int N;
    static int[] population;
    static List<Integer>[] adj;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        N = Integer.parseInt(br.readLine());
        population = new int[N + 1];
        adj = new ArrayList[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
            adj[i] = new ArrayList<>();
        }

        // 인접 리스트 구성
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                int neighbor = Integer.parseInt(st.nextToken());
                adj[i].add(neighbor);
            }
        }

        // 모든 가능한 조합 탐색 (비트마스킹)
        for (int mask = 1; mask < (1 << N) - 1; mask++) {
            List<Integer> group1 = new ArrayList<>();
            List<Integer> group2 = new ArrayList<>();

            // 두 그룹으로 나누기
            for (int i = 0; i < N; i++) {
                if ((mask & (1 << i)) != 0) {
                    group1.add(i + 1);
                } else {
                    group2.add(i + 1);
                }
            }

            // 각 그룹이 연결되어 있는지 확인
            if (isConnected(group1) && isConnected(group2)) {
                // 인구 차이 계산
                int sum1 = 0, sum2 = 0;
                for (int node : group1) {
                    sum1 += population[node];
                }
                for (int node : group2) {
                    sum2 += population[node];
                }

                minDiff = Math.min(minDiff, Math.abs(sum1 - sum2));
            }
        }

        // 결과 출력
        if (minDiff == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minDiff);
        }

        br.close();
    }

    // BFS로 연결성 확인
    static boolean isConnected(List<Integer> group) {
        if (group.isEmpty()) return false;

        Set<Integer> groupSet = new HashSet<>(group);
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(group.get(0));
        visited.add(group.get(0));

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int next : adj[curr]) {
                // 같은 그룹에 속하고 아직 방문하지 않은 노드
                if (groupSet.contains(next) && !visited.contains(next)) {
                    visited.add(next);
                    queue.offer(next);
                }
            }
        }

        // 그룹의 모든 노드를 방문했는지 확인
        return visited.size() == group.size();
    }
}