package baekjun_step.step4;

import java.io.*;

public class B2_3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] remain = new boolean[42]; // 역시나 보기 편하게 배열 index 1부터 시작.
        int count = 0;
        for(int i = 0; i < 10; i++) {
            int a = Integer.parseInt(br.readLine());
            int num = a % 42;
            if (remain[num] != true) {
                count++;
                remain[num] = true;
            }
        }
        bw.write(count+" ");

        bw.flush();
        br.close();
        bw.close();
    }
}
