package solved.silver.S3;
import java.io.*;
import java.util.*;

public class S3_15889 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 전우들의 좌표 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] positions = new int[n];
        for (int i = 0; i < n; i++) {
            positions[i] = Integer.parseInt(st.nextToken());
        }

        // n이 1이면 욱제 혼자이므로 바로 성공
        if (n == 1) {
            System.out.println("권병장님, 중대장님이 찾으십니다");
            return;
        }

        // 각 전우의 사거리 입력 (마지막 전우 제외)
        st = new StringTokenizer(br.readLine());
        int[] ranges = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            ranges[i] = Integer.parseInt(st.nextToken());
        }

        // BFS로 마지막 전우까지 도달 가능한지 확인
        boolean canReach = bfs(n, positions, ranges);

        if (canReach) {
            System.out.println("권병장님, 중대장님이 찾으십니다");
        } else {
            System.out.println("엄마 나 전역 늦어질 것 같아");
        }
    }

    private static boolean bfs(int n, int[] positions, int[] ranges) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        // 욱제(인덱스 0)부터 시작
        queue.offer(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 마지막 전우(인덱스 n-1)에 도달했으면 성공
            if (current == n - 1) {
                return true;
            }

            // 현재 전우의 사거리
            int range = ranges[current];
            int currentPos = positions[current];

            // 사거리 내에 있는 모든 전우를 확인
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    // 현재 위치에서 i번째 전우까지의 거리
                    int distance = Math.abs(positions[i] - currentPos);

                    // 사거리 내에 있으면 수류탄을 던질 수 있음
                    if (distance <= range) {
                        visited[i] = true;
                        queue.offer(i);
                    }
                }
            }
        }
        // 마지막 전우에 도달할 수 없음
        return false;
    }
}