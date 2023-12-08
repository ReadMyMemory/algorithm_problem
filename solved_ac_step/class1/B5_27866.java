package solved_ac_step.class1;

import java.io.*;

public class B5_27866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int index = Integer.parseInt(br.readLine());
        bw.write(str.charAt(index-1)+"");

        bw.flush();
        bw.close();
    }
}
