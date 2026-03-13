package solved.bronze.B1;
import java.io.*;
import java.util.*;

public class B1_25400 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int need = 1;

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x == need) {
                need++;
            }
        }

        int kept = need - 1;
        int answer = N - kept;
        System.out.println(answer);
    }
}