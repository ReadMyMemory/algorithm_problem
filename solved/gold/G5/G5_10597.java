package solved.gold.G5;
import java.io.*;
import java.util.*;

public class G5_10597 {

    static String s;
    static int n;
    static boolean[] used;
    static List<Integer> answer = new ArrayList<>();
    static boolean found = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine().trim();

        int len = s.length();

        if (len <= 9) {
            n = len;
        } else {
            n = (len + 9) / 2;
        }

        used = new boolean[n + 1];

        dfs(0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer.size(); i++) {
            if (i > 0) sb.append(' ');
            sb.append(answer.get(i));
        }
        System.out.println(sb);
    }

    static void dfs(int idx) {
        if (found) return;

        if (idx == s.length()) {
            if (answer.size() == n) {
                found = true;
            }
            return;
        }

        int one = s.charAt(idx) - '0';
        if (one >= 1 && one <= n && !used[one]) {
            used[one] = true;
            answer.add(one);

            dfs(idx + 1);

            if (found) return;

            used[one] = false;
            answer.remove(answer.size() - 1);
        }

        if (idx + 1 < s.length()) {
            if (s.charAt(idx) != '0') {
                int two = (s.charAt(idx) - '0') * 10 + (s.charAt(idx + 1) - '0');

                if (two >= 10 && two <= n && !used[two]) {
                    used[two] = true;
                    answer.add(two);

                    dfs(idx + 2);

                    if (found) return;

                    used[two] = false;
                    answer.remove(answer.size() - 1);
                }
            }
        }
    }
}