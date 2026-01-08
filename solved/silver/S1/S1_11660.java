package solved.silver.S1;
import java.io.*;
import java.util.*;

public class S1_11660 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[][] psum = new long[N + 1][N + 1]; // 1-indexed

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                long val = Long.parseLong(st.nextToken());
                psum[i][j] = psum[i - 1][j] + psum[i][j - 1] - psum[i - 1][j - 1] + val;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int q = 0; q < M; q++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            long ans = psum[x2][y2]
                    - psum[x1 - 1][y2]
                    - psum[x2][y1 - 1]
                    + psum[x1 - 1][y1 - 1];

            sb.append(ans).append('\n');
        }
        System.out.print(sb.toString());
    }
}
