package solved.bronze.B1;
import java.io.*;
import java.util.*;

public class B1_9506 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == -1) {
                break;
            }

            List<Integer> divisors = new ArrayList<>();
            int sum = 0;

            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    divisors.add(i);
                    sum += i;
                }
            }

            if (sum == n) {
                sb.append(n).append(" = ");
                for (int i = 0; i < divisors.size(); i++) {
                    sb.append(divisors.get(i));
                    if (i != divisors.size() - 1) {
                        sb.append(" + ");
                    }
                }
                sb.append('\n');
            } else {
                sb.append(n).append(" is NOT perfect.").append('\n');
            }
        }
        System.out.print(sb);
    }
}