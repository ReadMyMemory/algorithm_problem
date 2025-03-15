package solved.bronze.B1;
import java.io.*;
import java.util.*;

public class B1_1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            sb.append(lcm(A, B)).append("\n");
        }
        br.close();
        System.out.print(sb.toString());
    }

    // GCD 계산
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // LCM 계산
    private static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }
}
