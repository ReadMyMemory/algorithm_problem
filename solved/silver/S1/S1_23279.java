package solved.silver.S1;
import java.io.*;
import java.util.*;

public class S1_23279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int g = 0; g < K; g++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int[] r = new int[c];

            for (int i = 0; i < c; i++) {
                r[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(r);
            for (int i = 0; i < c; i++) {
                int a = r[i] + (i + 1); // 원래 서열 계산
                if (i > 0) sb.append(' ');
                sb.append(a);
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}
