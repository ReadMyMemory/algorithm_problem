package solved.bronze.B2;
import java.io.*;
import java.util.*;

public class B2_2798 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] a = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) a[i] = Integer.parseInt(st.nextToken());

        int best = 0;

        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int sum = a[i] + a[j] + a[k];
                    if (sum <= M && sum > best) {
                        best = sum;
                        if (best == M) {
                            System.out.print(best);
                            return;
                        }
                    }
                }
            }
        }
        System.out.print(best);
    }
}
