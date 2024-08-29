package solved.bronze.B3;
import java.io.*;
import java.util.StringTokenizer;

public class B3_9063 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int x_min = 10000;
        int x_max = -10000;
        int y_min = 10000;
        int y_max = -10000;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int temp_x = Integer.parseInt(st.nextToken());
            int temp_y = Integer.parseInt(st.nextToken());
            if(temp_x < x_min)
                x_min = temp_x;
            if(temp_x > x_max)
                x_max = temp_x;
            if(temp_y < y_min)
                y_min = temp_y;
            if(temp_y > y_max)
                y_max = temp_y;
        }
        System.out.println(Math.abs(y_max - y_min) * Math.abs(x_max - x_min));

    }
}
