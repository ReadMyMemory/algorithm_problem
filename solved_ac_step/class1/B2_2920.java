package solved_ac_step.class1;

import java.io.*;
import java.util.StringTokenizer;

public class B2_2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        boolean isMixed = false; // 한번이라도 순서가 안맞으면 true가 된다.
        int status = 0; // 이건 이제 순서가 맞는지 1씩 더한다. 이걸로 출력 조건 걸음.
        for(int i = 1; i < 8; i++) {
            if(!isMixed) { //mixed 조건이 한번이라도 검출되면, 끗
                if (start == 1) { // ascending 검사
                    if (i + 1 != Integer.parseInt(st.nextToken()))
                        isMixed = true;
                    status++;
                } else if (start == 8) { // descending 검사
                    if (8 - i != Integer.parseInt(st.nextToken()))
                        isMixed = true;
                    status--;
                }
            }
        }
        if(!isMixed && status == 7)
            bw.write("ascending");
        else if(!isMixed && status == -7)
            bw.write("descending");
        else
            bw.write("mixed");
        bw.flush();
        br.close();
        bw.close();
    }
}
