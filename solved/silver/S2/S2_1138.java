package solved.silver.S2;
import java.io.*;
import java.util.*;

public class S2_1138 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        int[] a = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> line = new ArrayList<>();

        // 키 큰 사람부터 배치
        for (int i = N; i >= 1; i--) {
            line.add(a[i], i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (i > 0) sb.append(' ');
            sb.append(line.get(i));
        }
        System.out.println(sb);
    }
}
