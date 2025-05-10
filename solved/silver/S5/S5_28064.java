package solved.silver.S5;
import java.io.*;

public class S5_28064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 사람 수 입력
        int N = Integer.parseInt(br.readLine().trim());
        String[] names = new String[N];

        // 이름들 읽기
        for (int i = 0; i < N; i++) {
            names[i] = br.readLine().trim();
        }

        // 서로 다른 사람 쌍 중 연결 가능한 경우 세기
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (canConnect(names[i], names[j])) {
                    count++;
                }
            }
        }

        // 결과 출력
        System.out.println(count);
    }

    /**
     * 두 이름 s, t에 대해
     * 1) s의 앞 k글자 == t의 뒤 k글자
     * 2) s의 뒤 k글자 == t의 앞 k글자
     * 를 만족하는 1 ≤ k ≤ min(|s|,|t|) 가 존재하면 true 반환
     */
    private static boolean canConnect(String s, String t) {
        int ls = s.length();
        int lt = t.length();
        int maxk = Math.min(ls, lt);

        for (int k = 1; k <= maxk; k++) {
            // s의 앞 k글자와 t의 뒤 k글자 비교
            if (s.substring(0, k).equals(t.substring(lt - k))) {
                return true;
            }
            // s의 뒤 k글자와 t의 앞 k글자 비교
            if (s.substring(ls - k).equals(t.substring(0, k))) {
                return true;
            }
        }
        return false;
    }
}
