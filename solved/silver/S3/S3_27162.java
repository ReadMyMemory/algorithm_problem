package solved.silver.S3;
import java.io.*;
import java.util.*;

public class S3_27162 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine().trim();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] fixed = new int[3];
        for (int i = 0; i < 3; i++) fixed[i] = Integer.parseInt(st.nextToken());

        List<Integer> available = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            if (s.charAt(i) == 'Y') available.add(i);
        }

        int maxScore = 0;

        for (int d1 = 1; d1 <= 6; d1++) {
            for (int d2 = 1; d2 <= 6; d2++) {
                int[] dice = { fixed[0], fixed[1], fixed[2], d1, d2 };

                for (int cat : available) {
                    maxScore = Math.max(maxScore, computeScore(dice, cat));
                }
            }
        }

        System.out.println(maxScore);
    }

    private static int computeScore(int[] dice, int categoryIdx) {
        if (0 <= categoryIdx && categoryIdx <= 5) {
            int target = categoryIdx + 1;
            int sum = 0;
            for (int d : dice) if (d == target) sum += d;
            return sum;
        }

        int[] cnt = new int[7];
        for (int d : dice) cnt[d]++;

        if (categoryIdx == 6) {
            // Four of a Kind
            for (int v = 1; v <= 6; v++) {
                if (cnt[v] >= 4) return v * 4;
            }
            return 0;
        }

        if (categoryIdx == 7) {
            // Full House
            boolean has3 = false, has2 = false;
            int distinct = 0;
            for (int v = 1; v <= 6; v++) {
                if (cnt[v] > 0) {
                    distinct++;
                    if (cnt[v] == 3) has3 = true;
                    else if (cnt[v] == 2) has2 = true;
                }
            }
            if (distinct == 2 && has3 && has2) {
                int sum = 0;
                for (int d : dice) sum += d;
                return sum;
            }
            return 0;
        }

        if (categoryIdx == 8) {
            // Little Straight 1~5
            int[] tmp = dice.clone();
            Arrays.sort(tmp);
            if (tmp[0]==1 && tmp[1]==2 && tmp[2]==3 && tmp[3]==4 && tmp[4]==5) return 30;
            return 0;
        }

        if (categoryIdx == 9) {
            // Big Straight 2~6
            int[] tmp = dice.clone();
            Arrays.sort(tmp);
            if (tmp[0]==2 && tmp[1]==3 && tmp[2]==4 && tmp[3]==5 && tmp[4]==6) return 30;
            return 0;
        }

        if (categoryIdx == 10) {
            // Yacht
            int first = dice[0];
            for (int d : dice) if (d != first) return 0;
            return 50;
        }

        if (categoryIdx == 11) {
            // Choice
            int sum = 0;
            for (int d : dice) sum += d;
            return sum;
        }

        return 0;
    }
}
