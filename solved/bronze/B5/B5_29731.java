package solved.bronze.B5;
import java.io.*;

public class B5_29731 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] list = new String[7];
        list[0] = "Never gonna give you up";
        list[1] = "Never gonna let you down";
        list[2] = "Never gonna run around and desert you";
        list[3] = "Never gonna make you cry";
        list[4] = "Never gonna say goodbye";
        list[5] = "Never gonna tell a lie and hurt you";
        list[6] = "Never gonna stop";

        int N = Integer.parseInt(br.readLine());
        boolean status = false; // true : 공약과 불일치 false : 공약과 일치
        while(N --> 0) {
            String s = br.readLine();
            boolean is_correct = false; // true : 일치하는 공약이 있음 false : 일치하는 공약이 없음
            for(int i = 0; i < 7; i++) {
                if(s.equals(list[i])) {
                    is_correct = true;
                    break;
                }
            }
            if(!is_correct) {
                status = true;
                break;
            }
        }
        if(status)
            System.out.println("Yes");
        else
            System.out.println("No");

    }
}
