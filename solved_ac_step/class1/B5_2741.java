package solved_ac_step.class1;

import java.io.*;

public class B5_2741 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int index = Integer.parseInt(br.readLine());
        int num = 1;
        while(index >= num) {
            bw.write(num+"\n");
            num++;
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
