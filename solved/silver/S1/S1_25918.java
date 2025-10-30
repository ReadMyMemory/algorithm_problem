package solved.silver.S1;
import java.io.*;
import java.util.*;

public class S1_25918 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim()); // 사용은 안 해도 입력 형식상 읽어둔다
        String s = br.readLine().trim();

        Deque<Character> st = new ArrayDeque<>();
        int maxSize = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!st.isEmpty() && st.peek() != c) {
                // 서로 다른 괄호면 () 또는 )( 이므로 상쇄
                st.pop();
            } else {
                // 같으면 쌓음
                st.push(c);
                if (st.size() > maxSize) maxSize = st.size();
            }
        }

        if (st.isEmpty()) {
            System.out.println(maxSize);
        } else {
            System.out.println(-1);
        }
    }
}
