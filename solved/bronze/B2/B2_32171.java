package solved.bronze.B2;
import java.io.*;
import java.util.*;

public class B2_32171 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int N = Integer.parseInt(br.readLine().trim());

        long minX = 0, minY = 0, maxX = 0, maxY = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken()); // 좌하단 x
            long b = Long.parseLong(st.nextToken()); // 좌하단 y
            long c = Long.parseLong(st.nextToken()); // 우상단 x
            long d = Long.parseLong(st.nextToken()); // 우상단 y

            if (i == 0) {
                minX = a; minY = b; maxX = c; maxY = d;
            } else {
                if (a < minX) minX = a;
                if (b < minY) minY = b;
                if (c > maxX) maxX = c;
                if (d > maxY) maxY = d;
            }

            long perimeter = 2L * ((maxX - minX) + (maxY - minY));
            out.append(perimeter).append('\n');
        }
        System.out.print(out.toString());
    }
}
