package solved.bronze.B3;
import java.io.*;
import java.util.*;

public class B3_5086 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String line = br.readLine();
            if (line == null) break;

            StringTokenizer st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0) break;

            if (b % a == 0) sb.append("factor\n");
            else if (a % b == 0) sb.append("multiple\n");
            else sb.append("neither\n");
        }

        System.out.print(sb.toString());
    }
}
