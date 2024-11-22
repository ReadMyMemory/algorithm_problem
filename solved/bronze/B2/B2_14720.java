package solved.bronze.B2;
import java.io.*;
import java.util.StringTokenizer;

public class B2_14720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int milk = 0; // 딸기 0 초코 1 바나나 2
        int count = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(N --> 0) {
            if(Integer.parseInt(st.nextToken()) == milk) {
                count++;
                if(milk == 2)
                    milk = 0;
                else
                    milk++;
            }
        }
        System.out.println(count);
    }
}
