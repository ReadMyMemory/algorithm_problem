package solved.bronze.B2;
import java.io.*;

public class B2_23627 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int length = s.length() - 1;
        if(length >= 4 && s.charAt(length) == 'p' && s.charAt(length-1) == 'i' && s.charAt(length-2) == 'i' && s.charAt(length-3) == 'r' && s.charAt(length-4) == 'd')
            bw.write("cute");
        else
            bw.write("not cute");
        bw.flush();
        br.close();
        bw.close();
    }
}
