package solved.bronze;
import java.io.*;
public class B4_11365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String str = br.readLine();
            if(str.equals("END"))
                break;
            for(int i = 0; i < str.length(); i++)
                bw.write(str.charAt(str.length()-1-i));
            bw.write("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
