package solved.silver.S2;
import java.io.*;
import java.util.*;

public class S2_1406 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String init = br.readLine();
        int m = Integer.parseInt(br.readLine());

        ArrayDeque<Character> left = new ArrayDeque<>();
        ArrayDeque<Character> right = new ArrayDeque<>();

        for (int i = 0; i < init.length(); i++) left.push(init.charAt(i));

        for (int i = 0; i < m; i++) {
            String cmd = br.readLine();
            char c = cmd.charAt(0);

            if (c == 'L') {
                if (!left.isEmpty()) right.push(left.pop());
            } else if (c == 'D') {
                if (!right.isEmpty()) left.push(right.pop());
            } else if (c == 'B') {
                if (!left.isEmpty()) left.pop();
            } else { // 'P'
                char x = cmd.charAt(2);
                left.push(x);
            }
        }

        StringBuilder sb = new StringBuilder(left.size() + right.size());

        // left는 스택이라 역순임 -> 한번 뒤집어서 출력
        ArrayDeque<Character> tmp = new ArrayDeque<>();
        while (!left.isEmpty()) tmp.push(left.pop());
        while (!tmp.isEmpty()) sb.append(tmp.pop());

        // right는 top이 커서 바로 오른쪽이므로, bottom부터 출력 -> 역순으로 붙이기 위해 뒤집기
        while (!right.isEmpty()) sb.append(right.pop());

        System.out.print(sb.toString());
    }
}
