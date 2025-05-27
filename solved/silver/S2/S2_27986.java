package solved.silver.S2;
import java.io.*;
import java.util.*;

public class S2_27986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int K = N; // K의 최댓값은 N
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            K = Math.min(K, R - L + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append((i % K) + 1);
            if (i != N - 1) sb.append(" ");
        }
        System.out.println(sb);
    }
}
