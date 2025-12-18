package solved.bronze.B3;
import java.io.*;
import java.util.*;

public class B3_10214 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 0; t < T; t++) {
            int sumY = 0, sumK = 0;

            for (int i = 0; i < 9; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int Y = Integer.parseInt(st.nextToken());
                int K = Integer.parseInt(st.nextToken());
                sumY += Y;
                sumK += K;
            }

            if (sumY > sumK) sb.append("Yonsei");
            else if (sumK > sumY) sb.append("Korea");
            else sb.append("Draw");

            if (t + 1 < T) sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}
