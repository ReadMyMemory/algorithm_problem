package solved;

import java.io.*;
import java.util.StringTokenizer;

public class a10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int[] arr = new int[2];
        arr[0] = Integer.parseInt(st.nextToken());
        arr[1] = Integer.parseInt(st.nextToken());

        while(st1.hasMoreTokens()) {
            int x = Integer.parseInt(st1.nextToken());
            if(arr[1] > x) {
                System.out.print(x+" ");
            }
        }
    }
}
