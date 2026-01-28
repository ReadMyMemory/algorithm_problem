package solved.bronze.B1;
import java.io.*;

public class B1_11653 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder();

        for (int p = 2; p * p <= n; p++) {
            while (n % p == 0) {
                sb.append(p).append('\n');
                n /= p;
            }
        }
        // 남은 수가 1이 아니면 소수(또는 마지막 인수)
        if (n > 1) sb.append(n).append('\n');
        System.out.print(sb.toString());
    }
}
