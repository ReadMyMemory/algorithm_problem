package baekjun_step.step4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1_1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        double sum = 0;
        int index = 0;
        int[] arr = new int[count];
        while(st.hasMoreTokens()) {
            arr[index] = Integer.parseInt(st.nextToken());
            index++;
        }

        Arrays.sort(arr); // 오름차순 정렬
        int max = arr[count-1];
        for(int i = 0; i < count; i++) {
            double dou = (double) arr[i] / max * 100;
            sum = sum + dou;
        }
        double average = (double) sum / count;
        bw.write(average+ " ");

        bw.flush();
        br.close();
        bw.close();
    }

}
