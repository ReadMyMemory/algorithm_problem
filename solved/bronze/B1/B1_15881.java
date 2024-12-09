package solved.bronze.B1;
import java.io.*;

public class B1_15881 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'p') {
                if(i + 3 < s.length() + 1) {
                    if(s.charAt(i+1) == 'P' && s.charAt(i+2) == 'A' && s.charAt(i+3) == 'p') {
                        count++;
                        i+=3;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
