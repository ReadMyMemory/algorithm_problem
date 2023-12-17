package solved;
import java.io.*;

public class B5_2743 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int num = str.length();
        
        bw.write(num+"");
        bw.flush();
        br.close();
        bw.close();
    }
}