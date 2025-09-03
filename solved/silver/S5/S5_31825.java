package solved.silver.S5;
import java.io.*;
import java.util.*;

public class S5_31825 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        char[] S = br.readLine().toCharArray();

        StringBuilder sb = new StringBuilder();

        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken()) - 1; // 0-indexed로 변환
            int r = Integer.parseInt(st.nextToken()) - 1;

            if (type == 1) {
                // 알파벳 묶음 개수 세기
                int count = countAlphabetGroups(S, l, r);
                sb.append(count).append("\n");
            } else {
                // 부분 문자열의 각 문자를 다음 알파벳으로 변경
                for (int i = l; i <= r; i++) {
                    if (S[i] == 'Z') {
                        S[i] = 'A';
                    } else {
                        S[i] = (char)(S[i] + 1);
                    }
                }
            }
        }
        System.out.print(sb);
    }

    private static int countAlphabetGroups(char[] S, int l, int r) {
        if (l > r) return 0;
        int count = 1; // 첫 문자부터 시작하는 그룹이 최소 1개

        for (int i = l + 1; i <= r; i++) {
            if (S[i] != S[i - 1]) {
                count++;
            }
        }
        return count;
    }
}