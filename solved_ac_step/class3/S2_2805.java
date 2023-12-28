package solved_ac_step.class3;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class S2_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 나무의 수
        int M = Integer.parseInt(st.nextToken()); // 나무의 길이
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        int index = 0;
        int min = 0;
        int max = 0;
        while(st.hasMoreTokens()) {
            arr[index] = Integer.parseInt(st.nextToken());
            if(max < arr[index]) max = arr[index];
            index++;
        }

        while(min < max) {
            int mid = (min + max) / 2;
            long sum = 0;
            for(int height : arr) {
                if (height - mid > 0)
                    sum += height - mid;
            }

            if(sum < M) // 자른 길이가 구하려는 길이보다 작다.
                max = mid; // 높이가 너무 높다. 내려야 한다.
            else // M보다 크거나 같다. 하지만 최대가 아닐 수 있다.
                min = mid + 1;
        }
        // 마지막에 1을 빼는 건 조건을 만족한 최고 높이에서 1을 더하고, 그 이후에 반복문 조건 미충족으로 탈출했기 때문이다.
        bw.write(Integer.toString(min-1));
        bw.flush();
        br.close();
        bw.close();
    }
}
