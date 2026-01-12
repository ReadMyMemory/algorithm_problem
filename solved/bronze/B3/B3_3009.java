package solved.bronze.B3;
import java.io.*;
import java.util.*;

public class B3_3009 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = 0, y = 0;

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int xi = Integer.parseInt(st.nextToken());
            int yi = Integer.parseInt(st.nextToken());

            x ^= xi;
            y ^= yi;
        }

        System.out.println(x + " " + y);
    }
}
