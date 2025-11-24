package solved.gold.G5;
import java.io.*;
import java.util.*;

public class G5_1490 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nStr = br.readLine().trim();

        // 1. N의 0이 아닌 자리수들의 최소공배수 M 계산
        boolean[] used = new boolean[10];
        for (int i = 0; i < nStr.length(); i++) {
            char c = nStr.charAt(i);
            if (c == '0') continue;
            used[c - '0'] = true;
        }

        int M = 1;
        for (int d = 1; d <= 9; d++) {
            if (used[d]) {
                int g = gcd(M, d);
                M = M / g * d; // lcm(M, d)
            }
        }

        // 혹시나 모든 자리가 0인 경우 (실제로는 N>=1이라 거의 안 나옴)
        if (M == 1) {
            System.out.println(nStr);
            return;
        }

        // 2. N 자체의 나머지 r0 = N % M 계산
        int r0 = 0;
        for (int i = 0; i < nStr.length(); i++) {
            int digit = nStr.charAt(i) - '0';
            r0 = (r0 * 10 + digit) % M;
        }

        // 이미 N이 조건을 만족하는 경우
        if (r0 == 0) {
            System.out.println(nStr);
            return;
        }

        // 3. BFS로 N 뒤에 붙일 최소 접미사 찾기
        int[] parent = new int[M];      // 어떤 나머지로부터 왔는지
        int[] parentDigit = new int[M]; // 그 때 붙인 숫자는 무엇인지
        Arrays.fill(parent, -1);

        Queue<Integer> q = new ArrayDeque<>();
        q.add(r0);
        parent[r0] = r0; // 시작 표시

        while (!q.isEmpty() && parent[0] == -1) {
            int cur = q.poll();

            for (int d = 0; d <= 9; d++) {
                int next = (cur * 10 + d) % M;
                if (parent[next] == -1) { // 아직 방문 안 한 나머지
                    parent[next] = cur;
                    parentDigit[next] = d;
                    q.add(next);
                }
            }
        }

        // 4. 나머지 0까지의 경로를 역추적해서 접미사 복원
        StringBuilder suffixRev = new StringBuilder();
        int cur = 0;
        while (parent[cur] != cur) { // 시작점 r0에 도달할 때까지
            suffixRev.append((char) ('0' + parentDigit[cur]));
            cur = parent[cur];
        }

        // 뒤에서부터 쌓았으니 뒤집기
        suffixRev.reverse();

        StringBuilder answer = new StringBuilder();
        answer.append(nStr).append(suffixRev);

        System.out.println(answer.toString());
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
