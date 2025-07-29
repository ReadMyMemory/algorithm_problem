package solved.silver.S3;
import java.io.*;

public class S3_1614 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long hurt = Long.parseLong(br.readLine()); // 다친 손가락(1~5)
        long N = Long.parseLong(br.readLine());    // 최대 사용할 수 있는 횟수

        if (N == 0) {
            // 다친 손가락을 아예 쓸 수 없으면, 셀 수 있는 최대값은
            // 엄지면 0, 새끼면 4까지 셀 수 있고, 나머지는 0
            if (hurt == 1) {
                System.out.println(0);
            } else if (hurt == 5) {
                System.out.println(4);
            } else {
                System.out.println(0);
            }
            return;
        }

        // 손가락 등장 시퀀스
        int[] seq = {1,2,3,4,5,4,3,2};
        int len = seq.length;

        // 다친 손가락의 주기 내 등장 횟수 구하기
        long cntPerCycle = 0;
        for (int i = 0; i < len; i++) {
            if (seq[i] == hurt) cntPerCycle++;
        }

        long fullCycle = N / cntPerCycle;
        long remain = N % cntPerCycle;

        long total = fullCycle * len;
        long add = 0;
        for (int i = 0; i < len; i++) {
            if (seq[i] == hurt) {
                if (remain == 0) break;
                remain--;
            }
            add++;
        }
        total += add;
        System.out.println(total);
    }
}
