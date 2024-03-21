package solved.bronze;
import java.io.*;
public class B4_10987 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            String temp = String.valueOf(str.charAt(i));
            if(temp.equals("a") || temp.equals("e") || temp.equals("i") || temp.equals("o") || temp.equals("u"))
                count++;
        }
        System.out.println(count);
        br.close();
    }
}
