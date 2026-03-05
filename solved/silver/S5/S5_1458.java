package solved.silver.S5;
import java.io.*;

public class S5_1458 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        int K = Integer.parseInt(br.readLine().trim());

        int[] maxPF = new int[N + 1];

        for (int i = 2; i <= N; i++) {
            if (maxPF[i] == 0) {
                for (int j = i; j <= N; j += i) {
                    maxPF[j] = i;
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (maxPF[i] <= K) count++;
        }
        System.out.println(count);
    }
}