package solved.silver.S3;
import java.io.*;

public class S3_1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        int[] alpha = new int[26];
        for (char c : name.toCharArray()) {
            alpha[c - 'A']++;
        }

        int oddCnt = 0;
        int oddIdx = -1;
        for (int i = 0; i < 26; i++) {
            if (alpha[i] % 2 != 0) {
                oddCnt++;
                oddIdx = i;
            }
        }

        if (oddCnt > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder half = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < alpha[i] / 2; j++) {
                half.append((char) (i + 'A'));
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(half);
        if (oddIdx != -1) {
            result.append((char) (oddIdx + 'A'));
        }
        result.append(half.reverse());

        System.out.println(result);
    }
}
