package baekjun_step.step4;

import java.io.*;

public class B3_2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[9];
        int max = 0;
        int index = 0;
        for(int i =0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (max < arr[i]) {
                max = arr[i];
                index = i+1;
            }
        }
        bw.write(max+"\n");
        bw.write(index+"\n");

        bw.flush();
        br.close();
        bw.close();
        }
    }
