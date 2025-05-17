package solved.silver.S3;
import java.io.*;
import java.util.*;

public class S3_32293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String S = br.readLine().trim();

        List<String> binaries = new ArrayList<>();
        int total = 1 << N; // 2^N

        for (int i = 0; i < total; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = N - 1; j >= 0; j--) {
                sb.append(((i >> j) & 1) == 1 ? '1' : '0');
            }
            binaries.add(sb.toString());
        }

        Collections.sort(binaries, (a, b) -> {
            int cntA = countOnes(a);
            int cntB = countOnes(b);
            if (cntA != cntB) return cntA - cntB;
            String revA = new StringBuilder(a).reverse().toString();
            String revB = new StringBuilder(b).reverse().toString();
            return revA.compareTo(revB);
        });

        for (int i = 0; i < binaries.size(); i++) {
            if (binaries.get(i).equals(S)) {
                System.out.println(i);
                return;
            }
        }
    }

    private static int countOnes(String s) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') cnt++;
        }
        return cnt;
    }
}
