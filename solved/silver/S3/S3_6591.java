package solved.silver.S3;
import java.io.*;

public class S3_6591 {
    // nCk 계산 함수
    public static long comb(int n, int k) {
        if (k == 0 || k == n) return 1;
        // nCk == nC(n-k)
        if (k > n - k) k = n - k;
        long res = 1;
        for (int i = 1; i <= k; i++) {
            res = res * (n - i + 1) / i;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] tokens = br.readLine().split(" ");
            int n = Integer.parseInt(tokens[0]);
            int k = Integer.parseInt(tokens[1]);
            if (n == 0 && k == 0) break;
            System.out.println(comb(n, k));
        }
    }
}
