package solved.gold.G5;
import java.io.*;
import java.util.*;

public class G5_1759 {

    static int L, C;
    static char[] arr;
    static StringBuilder sb = new StringBuilder();
    static final String VOWELS = "aeiou";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr); // 사전순 정렬

        char[] pick = new char[L];
        dfs(0, 0, 0, 0, pick);

        System.out.print(sb.toString());
    }

    static void dfs(int depth, int start, int vowel, int cons, char[] pick) {
        if (depth == L) {
            if (vowel >= 1 && cons >= 2) {
                sb.append(pick).append('\n');
            }
            return;
        }

        for (int i = start; i < C; i++) {
            char ch = arr[i];
            pick[depth] = ch;
            if (isVowel(ch)) {
                dfs(depth + 1, i + 1, vowel + 1, cons, pick);
            } else {
                dfs(depth + 1, i + 1, vowel, cons + 1, pick);
            }
        }
    }

    static boolean isVowel(char c) {
        return VOWELS.indexOf(c) >= 0;
    }
}
