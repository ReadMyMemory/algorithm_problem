package solved.bronze.B2;
import java.io.*;
import java.util.*;

public class B2_1712 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        if (B >= C) {
            System.out.println(-1);
            return;
        }

        long n = A / (C - B) + 1;
        System.out.println(n);
    }
}