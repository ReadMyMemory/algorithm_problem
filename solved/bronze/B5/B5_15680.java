package solved.bronze.B5;
import java.io.*;

public class B5_15680 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if(Integer.parseInt(br.readLine()) == 0)
            bw.write("YONSEI");
        else
            bw.write("Leading the Way to the Future");
        bw.flush();
        br.close();
        bw.close();
    }
}
