package solved.silver.S2;
import java.io.*;
import java.util.*;

public class S2_10252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            sb.append("1\n");

            // 첫 번째 열을 제외하고 ㄹ자로 탐색
            boolean leftToRight = true;

            for (int row = 0; row < m; row++) {
                if (leftToRight) {
                    // 왼쪽에서 오른쪽으로
                    for (int col = 1; col < n; col++) {
                        sb.append("(").append(row).append(",").append(col).append(")\n");
                    }
                } else {
                    // 오른쪽에서 왼쪽으로
                    for (int col = n - 1; col >= 1; col--) {
                        sb.append("(").append(row).append(",").append(col).append(")\n");
                    }
                }
                leftToRight = !leftToRight;
            }

            // 첫 번째 열을 아래에서 위로 탐색
            for (int row = m - 1; row >= 0; row--) {
                sb.append("(").append(row).append(",0)\n");
            }
        }
        System.out.print(sb);
    }
}