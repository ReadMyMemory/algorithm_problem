package solved.bronze;
import java.io.*;

public class B3_2441 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for(int i = N; i > 0; i--) {
            for(int w = N-i; w > 0; w--)
                bw.write(" ");
            for(int j = i; j > 0; j--)
                bw.write("*");
            bw.write("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
