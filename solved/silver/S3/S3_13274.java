package solved.silver.S3;

import java.io.*;
import java.util.*;

public class S3_13274 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        for (int q = 0; q < K; q++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            long X = Long.parseLong(st.nextToken());

            for (int i = L - 1; i <= R - 1; i++) {
                arr[i] += X;
            }

            Arrays.sort(arr);
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]);
            if (i != N - 1) sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
