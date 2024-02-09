package solved.bronze;
import java.io.*;

public class B5_9086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int number = Integer.parseInt(br.readLine());
        for(int i = 0; i < number; i++) {
            String str = br.readLine();
            bw.write(String.valueOf(str.charAt(0))+String.valueOf(str.charAt(str.length()-1))+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}

