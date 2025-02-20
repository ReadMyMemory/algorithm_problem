package solved.bronze.B4;
import java.io.*;

public class B4_5357 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while(T --> 0) {
            String s = br.readLine();
            StringBuilder sb = new StringBuilder();
            sb.append(s.charAt(0));

            for(int i = 1; i < s.length(); i++) {
                if (s.charAt(i) != s.charAt(i - 1)) {
                    sb.append(s.charAt(i));
                }
            }

            bw.write(sb.toString()+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
