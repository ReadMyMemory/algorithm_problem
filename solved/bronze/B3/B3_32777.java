package solved.bronze.B3;
import java.io.*;
import java.util.*;

public class B3_32777 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int Q = Integer.parseInt(br.readLine());

        for (int i = 0; i < Q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int innerDistance = (b > a) ? (b - a) : (43 - (a - b));
            int outerDistance = (a > b) ? (a - b) : (43 - (b - a));

            if (innerDistance < outerDistance) {
                sb.append("Inner circle line\n");
            } else if (innerDistance > outerDistance) {
                sb.append("Outer circle line\n");
            } else {
                sb.append("Same\n");
            }
        }
        System.out.print(sb);
    }
}
