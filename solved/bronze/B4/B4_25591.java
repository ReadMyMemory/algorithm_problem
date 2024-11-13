package solved.bronze.B4;
import java.io.*;
import java.util.StringTokenizer;

public class B4_25591 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int a = 100 - N;
        int b = 100 - M;
        int c = 100 - (a + b);
        int d = a * b;
        int q = 0;
        int r = d % 100;
        int first_num = 0;
        int second_num = 0;
        if(d >= 100) {
            q = d / 100;
            first_num = c + q;
            second_num = r;
        } else {
            first_num = c;
            second_num = d;
        }
        System.out.println(a + " " + b + " " + c + " " + d + " " + q + " " + r);
        System.out.println(first_num + " " + second_num);


    }
}
