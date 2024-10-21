package solved.bronze.B1;
import java.io.*;

public class B1_17294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        boolean is_cute = true;
        if(s.length() >= 2) {
            int standard = (s.charAt(1) - '0') - (s.charAt(0) - '0');
            for (int i = 1; i < s.length() - 1; i++) {
                if ((s.charAt(i + 1) - '0') - (s.charAt(i) - '0') != standard) {
                    is_cute = false;
                    break;
                }
            }
        }
        if(is_cute)
            System.out.println("◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!");
        else
            System.out.println("흥칫뿡!! <(￣ ﹌ ￣)>");
    }
}
