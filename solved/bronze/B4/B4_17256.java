package solved.bronze.B4;
import java.io.*;
import java.util.StringTokenizer;

public class B4_17256 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] a = new int[3];
        int[] c = new int[3];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 3; i++)
            a[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 3; i++)
            c[i] = Integer.parseInt(st.nextToken());
        System.out.println((c[2] - a[2])+" "+(c[2] / a[2])+" "+(c[2]-a[0]);


    }
}
