package class1.step4;

import java.io.*;

public class B5_5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[31];


        for(int i = 1; i <= 28; i++) { // 2명이 제출 안하니까 28번만 반복.
            int a = Integer.parseInt(br.readLine());
            arr[a] = 1;
        }

        for(int j = 1; j <= 30; j++) {
            if(arr[j] == 0)
                bw.write(j+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
