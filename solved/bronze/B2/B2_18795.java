import java.io.*;
import java.util.*;

public class B2_18795 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long sum = 0L;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sum += Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < M; j++) {
            sum += Long.parseLong(st.nextToken());
        }
        System.out.println(sum);
    }
}
