package solved.gold.G4;
import java.io.*;
import java.util.*;

public class G4_27984 {

    private static class Card {
        int s, r; // suit, rank

        Card(int s, int r) {
            this.s = s;
            this.r = r;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Card[] base = new Card[4];
        boolean[][] used = new boolean[4][14]; // [suit][rank]

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            base[i] = new Card(s, r);
            used[s][r] = true;
        }

        int bestGrade = -1;
        int bestS = 0, bestR = 1;

        // 조커를 모든 가능한 카드(아직 안 가진 48장)로 바꾸어 보며 최고 패 찾기
        for (int s = 0; s < 4; s++) {
            for (int r = 1; r <= 13; r++) {
                if (used[s][r]) continue; // 이미 가진 카드는 못 쓴다

                Card[] hand = new Card[5];
                for (int i = 0; i < 4; i++) hand[i] = base[i];
                hand[4] = new Card(s, r); // 조커를 이 카드로 변환

                int grade = evaluateHand(hand);
                if (grade > bestGrade) {
                    bestGrade = grade;
                    bestS = s;
                    bestR = r;
                }
            }
        }
        System.out.println(bestS + " " + bestR);
    }

    // 패의 등급 반환
    // 8: straight flush
    // 7: four of a kind
    // 6: full house
    // 5: flush
    // 4: straight
    // 3: triple
    // 2: two pair
    // 1: one pair
    // 0: high card
    private static int evaluateHand(Card[] cards) {
        int[] suitCnt = new int[4];
        int[] rankCnt = new int[14]; // 1~13 사용

        for (Card c : cards) {
            suitCnt[c.s]++;
            rankCnt[c.r]++;
        }

        boolean flush = false;
        for (int i = 0; i < 4; i++) {
            if (suitCnt[i] == 5) {
                flush = true;
                break;
            }
        }

        // straight 판정
        List<Integer> ranks = new ArrayList<>();
        for (int r = 1; r <= 13; r++) {
            if (rankCnt[r] > 0) ranks.add(r);
        }

        boolean straight = false;
        if (ranks.size() == 5) {
            Collections.sort(ranks);
            int first = ranks.get(0);
            if (ranks.get(4) - first == 4) {
                boolean ok = true;
                for (int i = 0; i < 5; i++) {
                    if (rankCnt[first + i] != 1) {
                        ok = false;
                        break;
                    }
                }
                straight = ok;
            }
        }

        int four = 0, three = 0, pair = 0;
        for (int r = 1; r <= 13; r++) {
            if (rankCnt[r] == 4) four++;
            else if (rankCnt[r] == 3) three++;
            else if (rankCnt[r] == 2) pair++;
        }

        if (straight && flush) return 8;
        if (four > 0) return 7;
        if (three > 0 && pair > 0) return 6;
        if (flush) return 5;
        if (straight) return 4;
        if (three > 0) return 3;
        if (pair == 2) return 2;
        if (pair == 1) return 1;
        return 0;
    }
}
