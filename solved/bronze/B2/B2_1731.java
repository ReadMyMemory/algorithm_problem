package solved.bronze.B2;
import java.io.*;

public class B2_1731 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] sequence = new int[N];

        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(br.readLine());
        }

        // 등차수열의 공차
        int diff = sequence[1] - sequence[0];
        // 등비수열의 공비
        int ratio = sequence[1] / sequence[0];

        boolean isArithmetic = true;
        boolean isGeometric = true;

        for (int i = 1; i < N - 1; i++) {
            if (sequence[i + 1] - sequence[i] != diff) {
                isArithmetic = false;
            }
            if (sequence[i + 1] / sequence[i] != ratio) {
                isGeometric = false;
            }
        }

        int nextNumber;
        if (isArithmetic) {
            nextNumber = sequence[N - 1] + diff;
        } else {
            nextNumber = sequence[N - 1] * ratio;
        }

        System.out.println(nextNumber);
    }
}
