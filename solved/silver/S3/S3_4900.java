package solved.silver.S3;
import java.io.*;
import java.util.*;

public class S3_4900 {
    // 숫자 -> 7세그먼트 코드
    private static final String[] DIGIT_TO_CODE = {
            "063","010","093","079","106","103","119","011","127","107"
    };
    // 7세그먼트 코드(3글자) -> 숫자문자('0'~'9')
    private static final Map<String, Character> CODE_TO_DIGIT = new HashMap<>();
    static {
        for (int d = 0; d <= 9; d++) {
            CODE_TO_DIGIT.put(DIGIT_TO_CODE[d], (char)('0' + d));
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder out = new StringBuilder();

        while ((line = br.readLine()) != null) {
            if (line.equals("BYE")) break;

            // 형태: A+B=
            int plusIdx = line.indexOf('+');
            int eqIdx   = line.indexOf('=');
            String Acode = line.substring(0, plusIdx);
            String Bcode = line.substring(plusIdx + 1, eqIdx);

            long a = decode(Acode);
            long b = decode(Bcode);
            long c = a + b;

            String Ccode = encode(c);
            out.append(line).append(Ccode).append('\n');
        }
        System.out.print(out.toString());
    }

    // 7세그먼트 코드 문자열(3글자씩 이어붙은 형태) -> 10진 정수
    private static long decode(String codeStr) {
        StringBuilder digits = new StringBuilder();
        for (int i = 0; i < codeStr.length(); i += 3) {
            String chunk = codeStr.substring(i, i + 3);
            Character ch = CODE_TO_DIGIT.get(chunk);
            // 문제 조건상 항상 유효 입력
            digits.append(ch);
        }
        return Long.parseLong(digits.toString());
    }

    // 10진 정수 -> 7세그먼트 코드 문자열(3글자씩)
    private static String encode(long value) {
        String s = Long.toString(value);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int d = s.charAt(i) - '0';
            sb.append(DIGIT_TO_CODE[d]);
        }
        return sb.toString();
    }
}
