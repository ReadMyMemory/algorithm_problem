package solved.bronze;
import java.io.*;

public class B4_1264 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = "";
        while(!(str = br.readLine()).equals("#")) {
            String temp = str.toUpperCase();
            int count = 0;
            for(int i = 0; i < temp.length(); i++) {
                String s = String.valueOf(temp.charAt(i));
                if(s.equals("A") || s.equals("E") || s.equals("I") || s.equals("O") || s.equals("U"))
                    count++;
            }
            bw.write(count+"\n");
        }
        bw.flush();
    }
}
