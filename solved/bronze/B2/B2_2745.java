package solved.bronze.B2;
import java.io.*;
import java.util.*;

public class B2_2745 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String n = st.nextToken();
        int b = Integer.parseInt(st.nextToken());

        int answer = 0;

        for (int i = 0; i < n.length(); i++) {
            char c = n.charAt(i);
            int value;

            if (c >= '0' && c <= '9') {
                value = c - '0';
            } else {
                value = c - 'A' + 10;
            }

            answer = answer * b + value;
        }
        System.out.println(answer);
    }
}