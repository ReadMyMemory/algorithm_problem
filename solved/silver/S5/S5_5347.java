package solved.silver.S5;
import java.io.*;
import java.util.StringTokenizer;

/*
문제 이름 처럼 최소공배수인 LCM은
GCD(최대공약수)를 구하는 유클리드 호제법을 통해서 구할 수 있다.
a * b = LCM * GCD가 성립하기 때문.
13241과 거의 동일한 문제라고 봐도 무방하다.
 */

public class S5_5347 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (testcase --> 0) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long LCM = a * b / EuclideanAlgorithm(Math.max(a, b), Math.min(a, b));
            System.out.println(LCM);
        }
    }

    static long EuclideanAlgorithm(long a, long b) {
        while(b != 0) {
            long tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }
}
