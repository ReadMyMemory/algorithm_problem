package solved.bronze.B3;
import java.io.*;
import java.util.*;

public class B3_10953 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < T; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line, ",");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(a + b).append('\n');
        }
        System.out.print(sb.toString());
    }
}
