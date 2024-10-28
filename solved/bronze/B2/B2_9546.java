package solved.bronze.B2;
import java.io.*;

public class B2_9546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testcase = Integer.parseInt(br.readLine());
        double temp = 0;
        for(int i = 0; i < testcase; i++) {
            int count = Integer.parseInt(br.readLine());
            while(count--> 0) {
                temp += 0.5;
                temp *= 2;
            }
            bw.write((int)temp+"\n");
            temp = 0;
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
