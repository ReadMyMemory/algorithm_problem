package solved.bronze.B3;
import java.io.*;

public class B3_26264 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int b_num = 0;
        int s_num = 0;
        String s = br.readLine();
        int index = 0;
        while(index < s.length()) {
            if (s.charAt(index) == 's') {
                s_num++;
                index += 8;
            } else {
                b_num++;
                index += 7;
            }
        }
        if(s_num > b_num)
            System.out.println("security!");
        else if(s_num == b_num)
            System.out.println("bigdata? security!");
        else
            System.out.println("bigdata?");
    }
}
