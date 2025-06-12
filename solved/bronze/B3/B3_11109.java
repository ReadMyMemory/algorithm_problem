package solved.bronze.B3;

import java.io.*;
import java.util.*;

public class B3_11109 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            int serial = n * s;
            int parallel = d + n * p;

            if (serial < parallel) {
                sb.append("do not parallelize\n");
            } else if (serial > parallel) {
                sb.append("parallelize\n");
            } else {
                sb.append("does not matter\n");
            }
        }
        System.out.print(sb);
    }
}

