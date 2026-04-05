package solved.bronze.B3;
import java.io.*;
import java.util.*;

public class B3_5073 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0 && c == 0) {
                break;
            }

            int max = Math.max(a, Math.max(b, c));
            int sum = a + b + c - max;

            if (max >= sum) {
                sb.append("Invalid\n");
            } else if (a == b && b == c) {
                sb.append("Equilateral\n");
            } else if (a == b || b == c || a == c) {
                sb.append("Isosceles\n");
            } else {
                sb.append("Scalene\n");
            }
        }
        System.out.print(sb);
    }
}