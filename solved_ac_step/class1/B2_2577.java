package solved_ac_step.class1;

import java.io.*;

public class B2_2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int[] arr = new int[10]; // 0~9 자리 수 기억
        long value = (long) A * B * C;
        String str = String.valueOf(value);
        for(int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - '0';
            arr[index]++;
        }
        for(int print : arr)
            bw.write(print+"\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
