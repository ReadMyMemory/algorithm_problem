package solved.bronze.B4;
import java.io.*;
import java.util.*;

public class B4_34543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 방문한 명소의 개수
        int W = Integer.parseInt(br.readLine()); // 총 걸음 수

        int score = 0;

        // 기본 점수: 방문한 명소 한 곳당 10점
        score += N * 10;

        // 3개 이상 방문 시 추가 20점
        if (N >= 3) {
            score += 20;
        }

        // 5개 모두 방문 시 특별 보너스 50점
        if (N == 5) {
            score += 50;
        }

        // 총 걸음 수가 1000보 초과 시 15점 감점
        if (W > 1000) {
            score -= 15;
        }

        // 점수는 0점 미만으로 내려가지 않음
        if (score < 0) {
            score = 0;
        }
        System.out.println(score);
    }
}