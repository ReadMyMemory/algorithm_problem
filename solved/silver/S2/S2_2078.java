package solved.silver.S2;
import java.io.*;
import java.util.*;

public class S2_2078 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int left = 0;
        int right = 0;

        // (1, 1)까지 거꾸로 추적
        while (a != 1 || b != 1) {
            if (a > b) {
                a -= b;
                left++;
            } else {
                b -= a;
                right++;
            }
        }
        System.out.println(left + " " + right);
    }
}
