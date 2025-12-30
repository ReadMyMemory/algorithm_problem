package solved.silver.S2;
import java.io.*;
import java.util.*;

public class S2_1024 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        for (int k = L; k <= 100; k++) {
            long subtract = (long) k * (k - 1) / 2;   // k*(k-1)/2
            long numerator = N - subtract;

            if (numerator < 0) break; // k가 더 커지면 subtract만 커져서 더 불가능

            if (numerator % k != 0) continue;

            long x = numerator / k;
            if (x < 0) continue;

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < k; i++) {
                if (i > 0) sb.append(' ');
                sb.append(x + i);
            }
            System.out.print(sb);
            return;
        }
        System.out.print(-1);
    }
}
