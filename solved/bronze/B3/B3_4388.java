package solved.bronze.B3;
import java.io.*;
import java.util.StringTokenizer;

public class B3_4388 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0)
                break;


            int cnt = 0;
            int carry = 0;

            while (a > 0 || b > 0) {
                int sum = (a % 10) + (b % 10) + carry;
                if (sum >= 10) {
                    cnt++;
                    carry = 1;
                } else {
                    carry = 0;
                }
                a /= 10;
                b /= 10;
            }

            System.out.println(cnt);
        }
    }
}
