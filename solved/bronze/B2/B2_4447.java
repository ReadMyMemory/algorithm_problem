package solved.bronze.B2;
import java.io.*;
public class B2_4447 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testcase = Integer.parseInt(br.readLine());
        while(testcase --> 0) {
            int g_num = 0;
            int b_num = 0;
            String temp = br.readLine();
            for(int i = 0; i < temp.length(); i++) {
                String s = String.valueOf(temp.charAt(i));
                s = s.toLowerCase(); // 소문자로 만들기
                if(s.equals("b"))
                    b_num++;
                else if(s.equals("g"))
                    g_num++;
            }
            bw.write(temp+" is ");
            if(g_num == b_num)
                bw.write("NEUTRAL\n");
            else if(g_num > b_num)
                bw.write("GOOD\n");
            else
                bw.write("A BADDY\n"); // BADDY가 아니라 A BADDY더라 ㅋㅋ
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
