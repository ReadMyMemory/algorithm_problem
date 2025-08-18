package solved.bronze.B4;
import java.io.*;

public class B4_34071 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문제의 수 N 입력
        int N = Integer.parseInt(br.readLine());

        // 문제들의 난이도를 저장할 배열
        int[] difficulties = new int[N];

        // N개의 난이도 입력
        for (int i = 0; i < N; i++) {
            difficulties[i] = Integer.parseInt(br.readLine());
        }

        // 첫 번째 문제의 난이도
        int firstDifficulty = difficulties[0];

        // 최소값과 최대값 찾기
        int min = difficulties[0];
        int max = difficulties[0];

        for (int i = 1; i < N; i++) {
            if (difficulties[i] < min) {
                min = difficulties[i];
            }
            if (difficulties[i] > max) {
                max = difficulties[i];
            }
        }

        // 첫 번째 문제의 난이도에 따라 결과 출력
        if (firstDifficulty == min) {
            System.out.println("ez");
        } else if (firstDifficulty == max) {
            System.out.println("hard");
        } else {
            System.out.println("?");
        }
    }
}