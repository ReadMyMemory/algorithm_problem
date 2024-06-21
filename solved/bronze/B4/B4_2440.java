package solved.bronze.B4;
import java.io.*;

public class B4_2440 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int number = Integer.parseInt(br.readLine());
        String str = "*";
        for(int i = number; i > 0; i--) {
            for(int j = 0; j < i; j++)
                bw.write(str);
            bw.write("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
