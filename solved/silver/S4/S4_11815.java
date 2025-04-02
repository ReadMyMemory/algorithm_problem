package solved.silver.S4;
import java.io.*;
public class S4_11815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            long X = Long.parseLong(inputs[i]);
            sb.append(isOddDivisorCount(X) ? "1" : "0").append(" ");
        }

        System.out.println(sb.toString().trim());
    }

    private static boolean isOddDivisorCount(long X) {
        // 약수의 개수가 홀수인 경우는 완전제곱수일 때만 해당됨
        long sqrt = (long) Math.sqrt(X);
        return sqrt * sqrt == X;
    }
}
