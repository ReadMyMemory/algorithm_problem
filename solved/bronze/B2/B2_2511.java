package solved.bronze.B2;
import java.io.*;

public class B2_2511 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // A와 B 카드 입력 받기
        String[] aLine = br.readLine().split(" ");
        String[] bLine = br.readLine().split(" ");

        int[] aCards = new int[10];
        int[] bCards = new int[10];

        for (int i = 0; i < 10; i++) {
            aCards[i] = Integer.parseInt(aLine[i]);
            bCards[i] = Integer.parseInt(bLine[i]);
        }

        int aScore = 0;
        int bScore = 0;
        char lastWinner = 'D'; // D는 무승부를 의미

        for (int i = 0; i < 10; i++) {
            if (aCards[i] > bCards[i]) {
                aScore += 3;
                lastWinner = 'A';
            } else if (aCards[i] < bCards[i]) {
                bScore += 3;
                lastWinner = 'B';
            } else {
                aScore += 1;
                bScore += 1;
            }
        }

        // 결과 출력
        System.out.println(aScore + " " + bScore);

        if (aScore > bScore) {
            System.out.println("A");
        } else if (aScore < bScore) {
            System.out.println("B");
        } else {
            System.out.println(lastWinner); // 점수가 같으면 마지막 승자를 출력 (없으면 무승부 D)
        }
    }
}
