package solved.bronze.B2;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B2_20299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        ArrayList<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int count = 0;
        while(N --> 0) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int x3 = Integer.parseInt(st.nextToken());
            int sum = x1 + x2 + x3;
            if (x1 >= L && x2 >= L && x3 >= L && sum >= K) {
                count++;
                list.add(x1);
                list.add(x2);
                list.add(x3);
            }
        }
        System.out.println(count);
        for(int a : list)
            bw.write(a+" ");
        bw.flush();
        br.close();
        bw.close();
    }
}
