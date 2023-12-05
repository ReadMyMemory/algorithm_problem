package class1.step4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B5_10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[num];
        int index = 0;
        while(st.hasMoreTokens()) {
            arr[index] = Integer.parseInt(st.nextToken());
            index++;
        }

        Arrays.sort(arr);
        bw.write(arr[0] + " " + arr[num-1]);

        bw.flush();
        br.close();
        bw.close();
    }
}
