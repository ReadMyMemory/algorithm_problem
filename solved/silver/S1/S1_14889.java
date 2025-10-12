package solved.silver.S1;
import java.io.*;
import java.util.*;

public class S1_14889 {
    static int N;
    static int[][] S;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        S = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // N/2명을 선택하는 조합 생성
        boolean[] selected = new boolean[N];
        combination(0, 0, selected);

        System.out.println(minDiff);
    }

    static void combination(int idx, int count, boolean[] selected) {
        // N/2명을 선택했으면 팀 능력치 계산
        if (count == N / 2) {
            calculateDiff(selected);
            return;
        }

        // 더 이상 선택할 수 없는 경우
        if (idx == N) {
            return;
        }

        // 현재 사람을 스타트 팀에 선택
        selected[idx] = true;
        combination(idx + 1, count + 1, selected);

        // 현재 사람을 링크 팀에 선택
        selected[idx] = false;
        combination(idx + 1, count, selected);
    }

    static void calculateDiff(boolean[] selected) {
        int startTeam = 0;
        int linkTeam = 0;

        // 스타트 팀 능력치 계산
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (selected[i] && selected[j]) {
                    startTeam += S[i][j] + S[j][i];
                } else if (!selected[i] && !selected[j]) {
                    linkTeam += S[i][j] + S[j][i];
                }
            }
        }
        int diff = Math.abs(startTeam - linkTeam);
        minDiff = Math.min(minDiff, diff);
    }
}