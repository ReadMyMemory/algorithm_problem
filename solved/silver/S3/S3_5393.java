package solved.silver.S3;
import java.io.*;

public class S3_5393 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            int ans = 0;
            if (x % 2 == 0) ans += x / 2;
            else ans += x / 2 + 1;
            if (x % 6 == 0 || x % 6 == 4) ans += x / 3;
            else ans += x / 3 + 1;
            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }
}
