package solved.bronze.B4;
import java.io.*;

public class B4_5524 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int number = Integer.parseInt(br.readLine());
        while(number --> 0)
            bw.write(br.readLine().toLowerCase()+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
