package solved.bronze.B1;
import java.io.*;

public class B1_16130 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int number = Integer.parseInt(br.readLine());
        while(number --> 0) {
            String s = br.readLine();
            int sum = 0;
            int match_value = 0;
            int week = 0;
            boolean is_break = false;
            for(int i = 0; i < s.length(); i++) {
                int c = s.charAt(i) - '0';
                if(c >= 17)
                    c -= 7;
                sum += c;
                if((sum / 10) - match_value != 0) {
                    int temp = week + (sum / 10) - match_value;
                    if(temp == 4) {
                        bw.write(week+"(weapon)\n");
                        is_break = true;
                        break;
                    } else if(temp > 4) {
                        bw.write(week+"(09)\n");
                        is_break = true;
                        break;
                    } else {
                        week += (sum / 10);
                        match_value = sum / 10;
                    }
                }
            }
            if(!is_break)
                bw.write(week+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
