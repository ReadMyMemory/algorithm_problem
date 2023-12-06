package solved_ac_step.class1;

import java.io.*;

public class B5_11654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        bw.write((int)str.charAt(0)+""); // +""를 해주지 않으면 제대로 출력이 안된다. 이유는..?
        bw.flush();
        br.close();
        bw.close();
    }
}
