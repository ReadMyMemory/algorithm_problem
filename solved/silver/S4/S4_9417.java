package solved.silver.S4;
import java.io.*;
import java.util.*;

public class S4_9417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int t = 0; t < n; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> numbers = new ArrayList<>();

            // 입력받은 숫자들을 리스트에 저장
            while (st.hasMoreTokens()) {
                numbers.add(Integer.parseInt(st.nextToken()));
            }

            int maxGcd = 0;

            // 모든 두 수의 쌍에 대해 GCD 계산
            for (int i = 0; i < numbers.size(); i++) {
                for (int j = i + 1; j < numbers.size(); j++) {
                    int currentGcd = gcd(Math.abs(numbers.get(i)), Math.abs(numbers.get(j)));
                    maxGcd = Math.max(maxGcd, currentGcd);
                }
            }
            System.out.println(maxGcd);
        }
    }

    // 유클리드 호제법으로 최대공약수 구하기
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}