package solved.bronze.B2;
import java.io.*;

/*
틀린 이유 : 반복문을 돌 때 마지막 숫자가 끝날 때까지 연속된 숫자가 이어지는 케이스에서
최대 길이가 나오는 경우 max가 갱신되야 하는데 갱신되지 않음.
 */

public class B2_2495 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int p = 0; p < 3; p++) {
            String s = br.readLine();
            int standard = s.charAt(0) - '0';
            int max = 1;
            int temp_max = 1;
            for(int i = 1; i < 8; i++) {
                if(standard == s.charAt(i) - '0') {
                    temp_max++;
                    if(i == 7) { // 숫자의 마지막 부분까지 연속된 수열이 나오는 경우, max 값 갱신 시도
                        if(max < temp_max)
                            max = temp_max;
                    }
                }
                else {
                    if(max < temp_max)
                        max = temp_max;
                    temp_max = 1;
                    standard = s.charAt(i) - '0';
                }
            };
            bw.write(String.valueOf(max)+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
