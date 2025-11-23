package solved.gold.G5;
import java.io.*;
import java.util.*;

/*
출발점(x)과 도착점(y) 사이 거리 d = y - x 에 대해:
어떤 수 n = ⌊√d⌋ 를 잡는다.

최소 이동 횟수 ans는 아래 3가지 경우 중 하나
1. d == n^2 → ans = 2n - 1
2. n^2 < d <= n^2 + n → ans = 2n
n^2 + n < d → ans = 2n + 1
*/

public class G5_1011 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            long d = y - x; // 거리
            long n = (long) Math.sqrt(d); // floor(sqrt(d))

            if (n * n == d) { // 딱 제곱수
                sb.append(2 * n - 1).append('\n');
            } else if (n * n < d && d <= n * n + n) { // 제곱수보다 크고 n^2 + n 이하
                sb.append(2 * n).append('\n');
            } else { // 그보다 크면
                sb.append(2 * n + 1).append('\n');
            }
        }
        System.out.print(sb.toString());
    }
}
