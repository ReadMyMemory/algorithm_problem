package solved.bronze.B3;
import java.io.*;
import java.util.*;

public class B3_25904 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] limit = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            limit[i] = Integer.parseInt(st.nextToken());
        }

        int idx = 0;
        int voice = X;

        while (true) {
            if (voice > limit[idx]) {
                System.out.println(idx + 1);
                break;
            }
            idx = (idx + 1) % N;
            voice++;
        }
    }
}