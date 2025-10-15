package solved.silver.S2;
import java.io.*;
import java.util.*;

public class S2_25212 {
    static int N;
    static int[] cakes;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cakes = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cakes[i] = Integer.parseInt(st.nextToken());
        }

        // 모든 부분집합을 확인 (공집합 제외)
        for (int mask = 1; mask < (1 << N); mask++) {
            if (isValidCake(mask)) {
                count++;
            }
        }
        System.out.println(count);
    }

    static boolean isValidCake(int mask) {
        // 선택된 케이크 조각들의 합 계산
        // 각 케이크는 1/c_i 판이므로, 분수 계산 필요
        // LCM을 구해서 통분하여 계산

        List<Integer> selected = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if ((mask & (1 << i)) != 0) {
                selected.add(cakes[i]);
            }
        }

        // 모든 분모의 LCM 구하기
        long lcm = 1;
        for (int c : selected) {
            lcm = lcm(lcm, c);
        }

        // 분자의 합 구하기
        long numerator = 0;
        for (int c : selected) {
            numerator += lcm / c;
        }

        // 99/100 <= numerator/lcm <= 101/100 인지 확인
        // numerator/lcm >= 99/100 -> 100 * numerator >= 99 * lcm
        // numerator/lcm <= 101/100 -> 100 * numerator <= 101 * lcm

        return 100 * numerator >= 99 * lcm && 100 * numerator <= 101 * lcm;
    }

    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}