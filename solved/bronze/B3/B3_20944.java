package solved.bronze.B3;
import java.io.*;

public class B3_20944 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++)
            bw.write("a");
        bw.flush();
        br.close();
        bw.close();
    }
}
