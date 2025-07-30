package solved.bronze.B4;
import java.io.*;
import java.util.*;

public class B4_10569 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int F = 2 - V + E; // 오일러 공식 F = 2 - V + E
            System.out.println(F);
        }
    }
}
