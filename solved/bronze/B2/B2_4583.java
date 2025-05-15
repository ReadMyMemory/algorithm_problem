package solved.bronze.B2;
import java.io.*;
import java.util.*;

public class B2_4583 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Character> mirror = new HashMap<>();
        mirror.put('b', 'd');
        mirror.put('d', 'b');
        mirror.put('p', 'q');
        mirror.put('q', 'p');

        // 자기 자신과 대응되는 문자들
        for (char c : new char[] {'i', 'o', 'v', 'w', 'x'}) {
            mirror.put(c, c);
        }

        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            if (line.equals("#")) break;
            sb.setLength(0);
            boolean valid = true;

            // 단어를 뒤에서부터 읽으면서 미러 매핑
            for (int i = line.length() - 1; i >= 0; i--) {
                char c = line.charAt(i);
                if (mirror.containsKey(c)) {
                    sb.append(mirror.get(c));
                } else {
                    valid = false;
                    break;
                }
            }

            // 결과 출력
            if (valid) {
                System.out.println(sb.toString());
            } else {
                System.out.println("INVALID");
            }
        }
    }
}
