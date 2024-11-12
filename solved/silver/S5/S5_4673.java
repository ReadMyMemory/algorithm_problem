package solved.silver.S5;
import java.io.*;

public class S5_4673 {
    static  boolean[] self_number;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        self_number = new boolean[10000];
        function(1); // 1을 모르고 제외해버림. 1도 셀프 넘버다.
        int index = 1;
        while(index < 10000) {
            if(self_number[index]) {
                index++;
                continue;
            } else {
                function(index);
                index++;
            }
        }
        for(int i = 1; i < 10000; i++) {
            if(!self_number[i])
                bw.write(i+"\n");
        }
        bw.flush();


    }
    static void function(int n) {
        while(n < 10000) {
            String s = String.valueOf(n);
            int temp = n;
            for (int i = 0; i < s.length(); i++)
                temp += s.charAt(i) - '0';
            n = temp;
            if(n >= 10000) break;
            self_number[n] = true;
        }
    }
}
