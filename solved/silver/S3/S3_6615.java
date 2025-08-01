package solved.silver.S3;
import java.io.*;
import java.util.*;

//A의 모든 콜라츠 수열 숫자와 그 step을 Map에 먼저 기록하고,
//B의 수열을 따라가며 A의 Map에 처음 등장하는 숫자를 찾는 방식
public class S3_6615 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());
            if (A == 0 && B == 0) break;

            Map<Long, Integer> aMap = new HashMap<>();
            long cur = A;
            int aStep = 0;
            while (true) {
                aMap.put(cur, aStep);
                if (cur == 1) break;
                if (cur % 2 == 0) cur /= 2;
                else cur = cur * 3 + 1;
                aStep++;
            }

            cur = B;
            int bStep = 0;
            long meetNum = -1;
            int ansAStep = -1, ansBStep = -1;

            while (true) {
                if (aMap.containsKey(cur)) {
                    meetNum = cur;
                    ansAStep = aMap.get(cur);
                    ansBStep = bStep;
                    break;
                }
                if (cur == 1) break;
                if (cur % 2 == 0) cur /= 2;
                else cur = cur * 3 + 1;
                bStep++;
            }
            System.out.printf("%d needs %d steps, %d needs %d steps, they meet at %d\n", A, ansAStep, B, ansBStep, meetNum);
        }
    }
}
