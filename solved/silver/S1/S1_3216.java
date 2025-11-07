package solved.silver.S1;
import java.io.*;
import java.util.*;

public class S1_3216 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        long[] D = new long[N];
        long[] V = new long[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            D[i] = Long.parseLong(st.nextToken());
            V[i] = Long.parseLong(st.nextToken());
        }

        // 반드시 첫 조각은 전부 다운로드 후 시작
        long ans = V[0];
        long buffer = D[0];

        for (int i = 1; i < N; i++) {
            if (buffer >= V[i]) {
                buffer = buffer - V[i] + D[i];
            } else {
                long need = V[i] - buffer;
                ans += need;
                buffer = D[i];
            }
        }
        System.out.println(ans);
    }
}
