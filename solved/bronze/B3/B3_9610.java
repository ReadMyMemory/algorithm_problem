package solved.bronze.B3;
import java.io.*;
import java.util.StringTokenizer;

public class B3_9610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[5];
        while(n --> 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(x == 0 || y == 0)
                arr[0]++;
            else if(x > 0 && y > 0)
                arr[1]++;
            else if(x < 0 && y > 0)
                arr[2]++;
            else if(x < 0 && y < 0)
                arr[3]++;
            else
                arr[4]++;
        }

        bw.write("Q1: "+arr[1]+"\n");
        bw.write("Q2: "+arr[2]+"\n");
        bw.write("Q3: "+arr[3]+"\n");
        bw.write("Q4: "+arr[4]+"\n");
        bw.write("AXIS: "+arr[0]);
        bw.flush();
        br.close();
        bw.close();
    }
}
