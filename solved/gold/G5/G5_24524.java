package solved.gold.G5;
import java.io.*;
import java.util.*;

public class G5_24524 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine().trim();
        String T = br.readLine().trim();

        int m = T.length();
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();

        // T의 각 문자를 인덱스로 매핑 (소문자 조건)
        int[] pos = new int[26];
        Arrays.fill(pos, -1);
        for (int i = 0; i < m; i++) pos[t[i] - 'a'] = i;

        long[] cnt = new long[m]; // cnt[j] = T의 앞 j+1글자까지 맞춰놓은 진행중 시도 수

        for (char ch : s) {
            int p = pos[ch - 'a'];
            if (p == -1) continue;             // T에 없는 문자는 무시
            if (p == 0) {
                cnt[0]++;                       // 새 시도 시작
            } else if (cnt[p - 1] > 0) {
                cnt[p - 1]--;                   // 이전 단계에서 하나를
                cnt[p]++;                       // 현재 단계로 진전
            }
            // p>0이고 cnt[p-1]==0이면 사용 불가(건너뜀)
        }
        System.out.println(cnt[m - 1]);         // 완성된 T의 개수
    }
}
