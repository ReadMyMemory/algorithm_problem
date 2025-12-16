package solved.gold.G4;
import java.io.*;
import java.util.*;

public class G4_1062 {
    static int N, K;
    static int[] words;
    static int answer = 0;

    // 필수 글자 a,n,t,i,c 비트
    static final int A = 1 << ('a' - 'a');
    static final int N_BIT = 1 << ('n' - 'a');
    static final int T = 1 << ('t' - 'a');
    static final int I = 1 << ('i' - 'a');
    static final int C = 1 << ('c' - 'a');
    static final int BASE = A | N_BIT | T | I | C;

    static boolean[] used = new boolean[26];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        words = new int[N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int mask = 0;
            for (int j = 0; j < s.length(); j++) {
                char ch = s.charAt(j);
                mask |= 1 << (ch - 'a');
            }
            words[i] = mask;
        }

        // K가 5 미만이면 필수 글자도 못 배워서 아무 단어도 못 읽음
        if (K < 5) {
            System.out.println(0);
            return;
        }

        // 알파벳 전부 배우면 모두 읽을 수 있음
        if (K == 26) {
            System.out.println(N);
            return;
        }

        // 필수 글자 사용 처리
        used['a' - 'a'] = true;
        used['n' - 'a'] = true;
        used['t' - 'a'] = true;
        used['i' - 'a'] = true;
        used['c' - 'a'] = true;

        int need = K - 5; // 추가로 더 배울 글자 수
        dfs(0, 0, BASE, need);

        System.out.println(answer);
    }

    /**
     * idx: 현재 알파벳 인덱스(0~25)
     * picked: 지금까지 추가로 고른 글자 수
     * known: 현재까지 아는 글자 비트마스크
     * need: 추가로 골라야 하는 총 글자 수(K-5)
     */
    static void dfs(int idx, int picked, int known, int need) {
        // 필요한 개수만큼 골랐으면 단어 카운트
        if (picked == need) {
            answer = Math.max(answer, countReadable(known));
            return;
        }

        // 알파벳 끝까지 갔는데 못 채우면 종료
        if (idx == 26) return;

        // 가지치기: 남은 알파벳으로도 need를 못 채우면 불가능
        if (picked + (26 - idx) < need) return;

        // 1) 이 알파벳을 고르지 않음
        dfs(idx + 1, picked, known, need);

        // 2) 이 알파벳을 고름(필수 글자는 이미 used=true라서 스킵됨)
        if (!used[idx]) {
            used[idx] = true;
            dfs(idx + 1, picked + 1, known | (1 << idx), need);
            used[idx] = false;
        }
    }

    // known으로 읽을 수 있는 단어 수 세기
    static int countReadable(int known) {
        int cnt = 0;
        for (int w : words) {
            // 단어에 있는 글자 중 known에 없는 게 하나도 없으면 읽을 수 있음
            if ((w & ~known) == 0) cnt++;
        }
        return cnt;
    }
}
