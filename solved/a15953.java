package solved;

import java.io.*;
import java.util.StringTokenizer;


public class a15953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int num = 0;
        int[][] arr = new int[count][2];
            for(int i = 0; i < count; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            };

            for(int j = 0; j < count; j++) {
                System.out.println(Math(arr[j][0], arr[j][1]));
            }

    };
    public static int Math(int level, int level2) {
        if(level == 0 || level > 21) level = 0;
        else if(level > 15) level = 10;
        else if(level > 10) level = 30;
        else if(level > 6) level = 50;
        else if(level > 3) level = 200;
        else if(level > 1) level = 300;
        else level = 500;

        if(level2 == 0 || level2 > 31) level2 = 0;
        else if(level2 > 15) level2 = 32;
        else if(level2 > 7) level2 = 64;
        else if(level2 > 3) level2 = 128;
        else if(level2 > 1) level2 = 256;
        else level2 = 512;

        return (level + level2) * 10000 ;
    }
}
