package solved.gold.G4;
import java.io.*;
import java.util.*;

public class G4_16397 {

    static final int MAX = 99999;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());

        int answer = bfs(N, T, G);
        if (answer == -1) {
            System.out.println("ANG");
        } else {
            System.out.println(answer);
        }
    }

    private static int bfs(int start, int maxPress, int goal) {
        int[] dist = new int[MAX + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            int d = dist[cur];

            if (d > maxPress) continue;   // 안전 체크
            if (cur == goal) return d;    // 최소 횟수

            if (d == maxPress) continue;  // 더 이상 버튼 못 누름

            // 1. 버튼 A
            int a = cur + 1;
            if (a <= MAX && dist[a] == -1) {
                dist[a] = d + 1;
                q.offer(a);
            }

            // 2. 버튼 B
            int b = pressB(cur);
            if (b != -1 && dist[b] == -1) {
                dist[b] = d + 1;
                q.offer(b);
            }
        }

        return -1;  // 못 가면 -1
    }

    private static int pressB(int x) {
        if (x == 0) return 0;

        int y = x * 2;
        if (y > MAX) return -1;  // 곱했을 때 바로 실패

        char[] arr = String.valueOf(y).toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '0') {
                arr[i]--; // 0이 아닌 가장 높은 자릿수를 1 줄이기
                break;
            }
        }
        return Integer.parseInt(new String(arr));
    }
}
