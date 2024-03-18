package solved.silver;
import java.io.*;
import java.util.StringTokenizer;

public class S5_13241 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());

        long LCM = a * b / EuclideanAlgorithm(Math.max(a, b), Math.min(a, b));
        System.out.println(LCM);


        /* 최소공배수(LCM)를 구하는데 있어 일반적으로 사용되는 방법은 유클리드 호제법이다.
        유클리드 호제법은 최대공약수(GCD)를 구하는 방법 아닌가요? 할 수도 있지만,
        a * b = GCD * LCM 이라는 점을 이용해서 LCM을 구할 수 있는 것이다.
        위 등식이 성립하는 이유에 대해 간단하게 설명해보겠다.
        a = k * GCD(a, b)
        b = l * GCD(a, b)
        GCD(a, b)가 최대 공약수이기 때문에 k와 l은 서로소이다.
        a * b = k * l * GCD(a, b) * GCD(a, b) 이다.
        이때 등식의 양변을 GCD(a, b)로 나누면
        (a * b) / GCD(a, b) = k * l * GCD(a, b)이다.
        이때 k와 l은 서로소이기 때문에 k * l * GCD(a, b)은 LCM(a, b)가 된다.
        따라서 a * b = GCD(a, b) * LCM(a, b)가 되는 것이다.
        이미 따라서 최소 공배수 LCM을 구하고자 하면 a * b 를 최대 공약수로 나누면 그게 최소공배수다.
         */

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
