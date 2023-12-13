package solved_ac_step.class2;

import java.io.*;

public class B1_1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        while(!(str = br.readLine()).equals("0")) { // 0을 입력받기 전까지 반복
            int originLength = str.length(); // 문장의 길이
            int length = 0; // 문장의 길이의 절반을 입력받기 위함
            if(originLength % 2 == 0)
                length = originLength / 2;
            else
                length = (originLength-1) / 2;
            boolean status = true; // 팰린드롬 yes 상태면 true, no 상태면 false다.
            for(int i =0; i < length; i++) {
                if (str.charAt(i) != str.charAt(originLength - 1 - i)) { // 양쪽 끝에서부터 한자리씩 일치하는지 대조하기.
                    status = false;
                    break;
                }
            }
            if(status)
                bw.write("yes\n");
            else
                bw.write("no\n");
        }
        bw.flush();
        br.close();
        bw.close();

    }
}
