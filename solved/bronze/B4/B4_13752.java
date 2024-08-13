package solved.bronze.B4;
import java.io.*;

public class B4_13752 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb;
        int testcase = Integer.parseInt(br.readLine());
        while(testcase --> 0) {
            int temp = Integer.parseInt(br.readLine());
            while (temp --> 0)
                bw.write("=");
            bw.write("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
