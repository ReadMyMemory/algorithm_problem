package solved.bronze.B3;
import java.io.*;
import java.util.StringTokenizer;

public class B3_2566 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int max_X = 0;
        int max_Y = 0;
        int max = -1;

        for(int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if(max < temp) {
                    max = temp;
                    max_X = i + 1;
                    max_Y = j + 1;
                }
            }
        }
        System.out.println(max);
        System.out.println(max_X+" "+max_Y);
    }
}
