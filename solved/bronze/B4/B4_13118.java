package solved.bronze.B4;
import java.io.*;
import java.util.StringTokenizer;

public class B4_13118 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[4];
        for(int i = 0; i < 4; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());

        boolean status = false;
        for(int i = 0; i < 4; i++) {
            if(arr[i] == x) {
                System.out.println(i + 1);
                status = true;
            }
        }

        if(!status)
            System.out.println(0);
    }
}
