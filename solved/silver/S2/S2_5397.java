package solved.silver.S2;
import java.io.*;
import java.util.*;

public class S2_5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String input = br.readLine();
            LinkedList<Character> password = new LinkedList<>();
            ListIterator<Character> cursor = password.listIterator();

            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);

                switch (ch) {
                    case '<':  // 커서를 왼쪽으로 이동
                        if (cursor.hasPrevious()) {
                            cursor.previous();
                        }
                        break;

                    case '>':  // 커서를 오른쪽으로 이동
                        if (cursor.hasNext()) {
                            cursor.next();
                        }
                        break;

                    case '-':  // 백스페이스 - 커서 앞의 문자 삭제
                        if (cursor.hasPrevious()) {
                            cursor.previous();
                            cursor.remove();
                        }
                        break;

                    default:  // 일반 문자 입력
                        cursor.add(ch);
                        break;
                }
            }
            // 결과 출력
            for (char ch : password) {
                sb.append(ch);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}