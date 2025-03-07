package solved.bronze.B2;
import java.io.*;
import java.util.*;

public class B2_5618 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int gcdValue = numbers[0];
        for (int i = 1; i < n; i++) {
            gcdValue = gcd(gcdValue, numbers[i]);
        }

        List<Integer> divisors = getDivisors(gcdValue);
        for (int divisor : divisors) {
            System.out.println(divisor);
        }
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private static List<Integer> getDivisors(int num) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                divisors.add(i);
                if (i != num / i) {
                    divisors.add(num / i);
                }
            }
        }
        Collections.sort(divisors);
        return divisors;
    }
}
