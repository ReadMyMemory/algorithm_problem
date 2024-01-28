package solved_ac_step.class2;

import java.io.*;
import java.util.StringTokenizer;

public class S5_7568 {
//
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int number = Integer.parseInt(br.readLine());
        int[][] arr = new int [number][2];

        for(int i = 0; i < number; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < number; i++) {
            int grade = 1;
            for(int j = 0; j < number; j++) {
                if(i == j) continue;
                if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1])
                    grade++;
            }
            bw.write(grade+" ");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
