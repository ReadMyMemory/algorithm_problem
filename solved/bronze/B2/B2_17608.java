package solved.bronze.B2;
import java.io.*;

public class B2_17608 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int idx = 1;
        while(N --> 0)
            arr[idx++] = Integer.parseInt(br.readLine());
        int max = 0;
        int count = 0;
        for(int i = arr.length - 1; i > 0; i--) {
            if(max < arr[i]) {
                count++;
                max = arr[i];
            }
        }
        System.out.println(count);
    }
}
