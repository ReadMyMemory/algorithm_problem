package solved.silver.S5;
import java.io.*;

public class S5_22935 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            long N = Long.parseLong(br.readLine().trim());
            // 주기를 2*15-2 = 28로 삼아 위치 계산
            int pos = (int)(((N - 1) % 28) + 1);
            // 1~15까지 올리고, 그 다음 14~2로 내리는 'zig-zag' 값
            int num = (pos <= 15) ? pos : 30 - pos;

            // 4비트 이진수로 변환하여 1이면 "딸기", 0이면 "V"
            for (int b = 3; b >= 0; b--) {
                if (((num >> b) & 1) == 1) {
                    sb.append("딸기");
                } else {
                    sb.append("V");
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
