package solved.bronze.B1;
import java.io.*;

public class B1_2930 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int R = Integer.parseInt(br.readLine());
        String sanggeunMoves = br.readLine();
        int N = Integer.parseInt(br.readLine());

        String[] friendsMoves = new String[N];
        for (int i = 0; i < N; i++) {
            friendsMoves[i] = br.readLine();
        }

        int actualScore = calculateScore(sanggeunMoves, friendsMoves);
        int maxPossibleScore = calculateMaxScore(R, friendsMoves);

        bw.write(actualScore + "\n");
        bw.write(maxPossibleScore + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int calculateScore(String sanggeun, String[] friends) {
        int score = 0;
        int R = sanggeun.length();

        for (int i = 0; i < R; i++) {
            char sMove = sanggeun.charAt(i);
            for (String friend : friends) {
                char fMove = friend.charAt(i);
                score += getScore(sMove, fMove);
            }
        }
        return score;
    }

    private static int calculateMaxScore(int R, String[] friends) {
        int maxScore = 0;
        char[] moves = {'S', 'P', 'R'};

        for (int i = 0; i < R; i++) {
            int bestRoundScore = 0;

            for (char move : moves) {
                int roundScore = 0;
                for (String friend : friends) {
                    roundScore += getScore(move, friend.charAt(i));
                }
                bestRoundScore = Math.max(bestRoundScore, roundScore);
            }

            maxScore += bestRoundScore;
        }
        return maxScore;
    }

    private static int getScore(char s, char f) {
        if (s == f) return 1;
        if ((s == 'S' && f == 'P') || (s == 'P' && f == 'R') || (s == 'R' && f == 'S')) return 2;
        return 0;
    }
}
