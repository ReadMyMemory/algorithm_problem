package solved.bronze.B1;
import java.io.*;
import java.util.*;
import java.math.*;

public class B1_4328 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String line = br.readLine();
            if (line == null) break;

            line = line.trim();
            // 마지막 줄: 0 하나만 들어오면 종료
            if (line.equals("0")) break;

            StringTokenizer st = new StringTokenizer(line);
            int b = Integer.parseInt(st.nextToken()); // 진법
            String p = st.nextToken();                // 피제수
            String m = st.nextToken();                // 나누는 수

            // p, m 은 b진법으로 표현된 큰 정수이므로 BigInteger를 사용
            BigInteger bigP = new BigInteger(p, b);
            BigInteger bigM = new BigInteger(m, b);

            BigInteger r = bigP.mod(bigM);            // 나머지 계산
            String result = r.toString(b);            // 다시 b진법 문자열로 변환

            sb.append(result).append('\n');
        }
        System.out.print(sb.toString());
    }
}
