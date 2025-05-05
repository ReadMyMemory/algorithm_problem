package solved.silver.S4;
import java.io.*;
import java.util.Arrays;

public class S4_1758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 사람 수 N 읽기
        int N = Integer.parseInt(br.readLine().trim());

        // 팁 배열 생성 및 입력
        long[] tips = new long[N];
        for (int i = 0; i < N; i++) {
            tips[i] = Long.parseLong(br.readLine().trim());
        }

        // 내림차순 정렬을 위해 오름차순 정렬 후 뒤에서부터 접근
        Arrays.sort(tips);

        long totalTip = 0;
        // i번째로 커피를 주는 손님은 (받은 등수 = i+1)이므로
        // 실제 팁 = tipsSortedDesc[i] - (i)
        for (int i = 0; i < N; i++) {
            long tip = tips[N - 1 - i] - i;
            if (tip > 0) {
                totalTip += tip;
            } else {
                // 이 시점부터는 모두 음수가 되므로 중단
                break;
            }
        }
        System.out.println(totalTip);
    }
}
